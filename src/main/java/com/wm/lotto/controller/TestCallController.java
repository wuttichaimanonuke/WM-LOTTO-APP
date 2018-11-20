package com.wm.lotto.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("testCallApi")
public class TestCallController {

	private static final Logger log = LoggerFactory.getLogger(TestCallController.class);
	
	@RequestMapping(value = "/testPost01", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> testPost01() {
		log.info("(POST) mapping to checkThisToken : Begin.");
		log.info("@RequestBody : not request.");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("HeaderResponse", "=TestHeaderResponse");
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", "jsonResponseExample");
		log.info("result : {}",result.get("result"));
		return new ResponseEntity<Map<String,Object>>(result, responseHeaders, HttpStatus.OK);
	}
}
