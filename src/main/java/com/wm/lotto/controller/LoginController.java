package com.wm.lotto.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wm.lotto.entity.LoginUser;
import com.wm.lotto.entity.RequestDataEntity;
import com.wm.lotto.entity.TokenLogin;
import com.wm.lotto.service.ILoginService;

@RestController
@RequestMapping("login_app")
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private ILoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> loginApp(@RequestBody RequestDataEntity<LoginUser> seriesValue) {
		log.info("(POST) mapping to login : Begin.");
		log.info("@RequestBody : token = {}, dataValue = {}", seriesValue.getToken(),seriesValue.getDataValue());
		LoginUser loginUser = seriesValue.getDataValue().get(0);
		log.info("username = {} ,password = {}",loginUser.getUsername(),loginUser.getPassword());
		log.info("loginUser = {}",loginUser.toString());
		
		TokenLogin result = new TokenLogin();
		try {
			result = loginService.login(loginUser);
			log.info("Service return token = "+result.getTlToken());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<TokenLogin>(result, HttpStatus.OK);
	}
	
}
