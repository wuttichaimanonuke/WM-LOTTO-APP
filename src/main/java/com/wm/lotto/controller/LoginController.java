package com.wm.lotto.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wm.lotto.entity.general.LoginUser;
import com.wm.lotto.entity.general.RequestDataEntity;
import com.wm.lotto.entity.token_login.TokenLogin;
import com.wm.lotto.service.login.ILoginService;

@RestController
@RequestMapping("login_app")
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	private static final String LOGIN_SUCCESS_CODE = "LOGI200";
	private static final String LOGIN_SUCCESS_MSG = "Login success.";
	private static final String LOGIN_FAILED_CODE = "LOGI204";
	private static final String LOGIN_FAILED_MSG = "Login failed.";
	private static final String LOGIN_NOT_FOUND_CODE = "LOGI404";
	private static final String LOGIN_NOT_FOUND_MSG = "User not found.";
	private static final String LOGIN_INPUT_INVALID_CODE = "LOGI400";
	private static final String LOGIN_INPUT_INVALID_MSG = "Input data invalid.";
	
	private static final String LOGOUT_SUCCESS_CODE = "LOGO200";
	private static final String LOGOUT_SUCCESS_MSG = "Logout success.";
	private static final String LOGOUT_FAILED_CODE = "LOGO204";
	private static final String LOGOUT_FAILED_MSG = "Logout failed.";
	
	@Autowired
	private ILoginService loginService;
	
	@RequestMapping(value = "/login_func", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> loginFuncApp(@RequestHeader String username, @RequestHeader String password) {
		log.info("(POST) mapping to login_func : Begin.");
		log.info("@RequestHeader : username = {}, password = {}", username, password);
		Map<String, Object> result = new HashMap<String, Object>();
		TokenLogin tokenLogin = new TokenLogin();
		if (	!(username.trim().isEmpty())	&& 	!(username.equals(null))
			&&	!(password.trim().isEmpty())	&&	!(password.equals(null))
		) {
			try {
				tokenLogin = loginService.loginWithFunc(username, password);
				switch (tokenLogin.getTlToken()) {
				case "INPUT INVALID":
					result.put("resultCode", LOGIN_INPUT_INVALID_CODE);
					result.put("resultMessage", LOGIN_INPUT_INVALID_MSG);
					break;
				case "USER NOT FOUND":
					result.put("resultCode", LOGIN_NOT_FOUND_CODE);
					result.put("resultMessage", LOGIN_NOT_FOUND_MSG);
					break;
				case "EXCEPTION OTHER":
					result.put("resultCode", LOGIN_FAILED_CODE);
					result.put("resultMessage", LOGIN_FAILED_MSG);
					break;
				default:
					result.put("resultCode", LOGIN_SUCCESS_CODE);
					result.put("resultMessage", LOGIN_SUCCESS_MSG);
					result.put("token", tokenLogin.getTlToken());
					result.put("uId", tokenLogin.getUId());
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				result.put("resultCode", LOGIN_FAILED_CODE);
				result.put("resultMessage", LOGIN_FAILED_MSG);
			}
		} else {
			result.put("resultCode", LOGIN_INPUT_INVALID_CODE);
			result.put("resultMessage", LOGIN_INPUT_INVALID_MSG);
		}
		log.info("Service return value = {},",result);
		return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> loginApp(@RequestBody RequestDataEntity<LoginUser> seriesValue) {
		log.info("(POST) mapping to login : Begin.");
		log.info("@RequestBody : token = {}, dataValue = {}", seriesValue.getToken(),seriesValue.getDataValue());
		log.info("seriesValue = {}",seriesValue.toString());
		LoginUser loginUser = seriesValue.getDataValue().get(0);
		log.info("username = {} ,password = {}",loginUser.getUsername(),loginUser.getPassword());
		log.info("loginUser = {}",loginUser.toString());
		Map<String, Object> result = new HashMap<String, Object>();
		TokenLogin tokenLogin = new TokenLogin();
		try {
			tokenLogin = loginService.login(loginUser);
			result.put("token", tokenLogin.getTlToken());
			result.put("uId", tokenLogin.getUId());
			log.info("Service return token = {}, uId = {}",tokenLogin.getTlToken(), tokenLogin.getUId());
			if ((result.get("token") == null) || (result.get("uId") == null)) {
				return new ResponseEntity<Map<String,Object>>(result, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Map<String,Object>>(result, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Map<String,Object>>(result, HttpStatus.FOUND);
	}
	
	@RequestMapping(value = "/logout_proc", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> logoutProcApp(@RequestHeader String token) {
		log.info("(POST) mapping to logout_proc : Begin.");
		log.info("@RequestHeader : token = {}", token);
		Map<String, Object> result = new HashMap<String, Object>();
		String result_service = null;
		if (	!(token.trim().isEmpty())	&& 	!(token.equals(null)) ) {
			try {
				result_service = loginService.logoutWithProc(token);
				switch (result_service) {
				case "OK":
					result.put("resultCode", LOGOUT_SUCCESS_CODE);
					result.put("resultMessage", LOGOUT_SUCCESS_MSG);
					break;
				case "NOT FOUND":
					result.put("resultCode", LOGOUT_FAILED_CODE);
					result.put("resultMessage", LOGOUT_FAILED_MSG);
					break;
				default:
					result.put("resultCode", LOGOUT_FAILED_CODE);
					result.put("resultMessage", LOGOUT_FAILED_MSG);
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				result.put("resultCode", LOGOUT_FAILED_CODE);
				result.put("resultMessage", LOGOUT_FAILED_MSG);
			}
		} else {
			result.put("resultCode", LOGOUT_FAILED_CODE);
			result.put("resultMessage", LOGOUT_FAILED_MSG);
		}
		log.info("Service return value = {},",result);
		return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);
	}
}
