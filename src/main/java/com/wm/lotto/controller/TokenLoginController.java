package com.wm.lotto.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.wm.lotto.entity.general.LoginUser;
import com.wm.lotto.entity.general.RequestDataEntity;
import com.wm.lotto.entity.general.TestFetchCallApi;
import com.wm.lotto.entity.users.Users;
import com.wm.lotto.service.token.ITokenService;

@RestController
@RequestMapping("tokenlogin")
public class TokenLoginController {

	private static final Logger log = LoggerFactory.getLogger(TokenLoginController.class);
	
	@Autowired
	private ITokenService tokenService;
	
	@RequestMapping(value = "/checkThisToken", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> checkThisToken(@RequestBody RequestDataEntity<String> seriesValue) {
		log.info("(POST) mapping to checkThisToken : Begin.");
		log.info("@RequestBody : token = {}, dataValue = {}", seriesValue.getToken(),seriesValue.getDataValue());
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if (tokenService.checkThisToken(seriesValue.getToken())) {
				result.put("result", true);
				log.info("Service return result[{}].",result);
				return new ResponseEntity<Map<String,Object>>(result, HttpStatus.FOUND);
			} else {
				result.put("result", false);
				log.info("Service return result[{}].",result);
				return new ResponseEntity<Map<String,Object>>(result, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			result.put("result", false);
			log.info("Service checkThisToken is error. : {}",e.getMessage());
			return new ResponseEntity<Map<String,Object>>(result, HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/checkThisTokenByTkUid", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> checkThisTokenByTkUid(@RequestBody RequestDataEntity<Users> seriesValue) {
		log.info("(POST) mapping to checkThisTokenByTkUid : Begin.");
		log.info("@RequestBody : token = {}, dataValue = {}", seriesValue.getToken(),seriesValue.getDataValue());
		Map<String, Object> result = new HashMap<String, Object>();
		String token = seriesValue.getToken();
		Users user = seriesValue.getDataValue().get(0);
		log.debug("token = {}, uId = {}", token, user.getuId());
		try {
			if (tokenService.checkThisTokenByTkUid(token, user.getuId())) {
				result.put("result", true);
				log.info("Service return result[{}].",result);
				return new ResponseEntity<Map<String,Object>>(result, HttpStatus.FOUND);
			} else {
				result.put("result", false);
				log.info("Service return result[{}].",result);
				return new ResponseEntity<Map<String,Object>>(result, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			result.put("result", false);
			log.info("Service checkThisTokenByTkUid is error. : {}",e.getMessage());
			return new ResponseEntity<Map<String,Object>>(result, HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/testPost01", method = RequestMethod.POST)
	public ResponseEntity<?> testPost01() {
		log.info("(POST) mapping to checkThisToken : Begin.");
		log.info("@RequestBody : not request.");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("HeaderResponse", "=TestHeaderResponse");
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", true);
		log.info("result : {}",result.get("result"));
//		return new ResponseEntity<String>("{\"result\": \"jsonResponseExample\"}", responseHeaders, HttpStatus.OK);
		return new ResponseEntity<Map<String,Object>>(result, responseHeaders, HttpStatus.OK);
	}
}
