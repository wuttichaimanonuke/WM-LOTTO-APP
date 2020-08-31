package com.wm.lotto.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wm.lotto.general.ConstantsResult;
import com.wm.lotto.service.round_configure.IRoundConfigureService;

@RestController
@RequestMapping("roundConfigure")
public class RoundConfigureController {

	private static final Logger log = LoggerFactory.getLogger(RoundConfigureController.class);
	
	@Autowired
	private IRoundConfigureService roundConfigreService;
	
	@RequestMapping(value = "/getCurrentActiveRoundConfigure", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getCurrentActiveRoundConfigure(@RequestHeader String appToken) {
		log.info("(POST) mapping to getCurrentActiveRoundConfigure : Begin.");
		log.info("@RequestHeader : appToken = {}", appToken);
		Map<String, Object> result = new HashMap<String, Object>();
		if (	!(appToken.trim().isEmpty())	&& 	!(appToken.equals(null)) ) {
			try {
				result = roundConfigreService.getCurrentActiveRoundConfigure(appToken);
			} catch (Exception e) {
				result.put("resultCode", ConstantsResult.GET_CURRENT_ACTIVE_ROUNDCONFIG_DATAERROR_CODE);
				result.put("resultMessage", ConstantsResult.GET_CURRENT_ACTIVE_ROUNDCONFIG_DATAERROR_MSG);
			}
		} else {
			result.put("resultCode", ConstantsResult.CHECK_TOKEN_IS_EXPIRE_FAIL_CODE);
			result.put("resultMessage", ConstantsResult.CHECK_TOKEN_IS_EXPIRE_FAIL_MSG);
		}
		return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);
	}
}
