package com.example.demorestjdbc.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demorestjdbc.entity.CpbRoleJoinCpbRoleType;
import com.example.demorestjdbc.service.ICpbRoleService;

@RestController
@RequestMapping("cpb_role")
public class CpbRoleController {

	private static final Logger log = LoggerFactory.getLogger(CpbRoleController.class);
	
	@Autowired
	private ICpbRoleService cpbRoleService;
	
	@RequestMapping(value = "allCpbRoleJoinCpbRoleType", method = RequestMethod.GET)
	public ResponseEntity<List<CpbRoleJoinCpbRoleType>> getAllCpbRoleJoinCpbRoleType() {
		log.info("(GET) mapping to getAllCpbRoleJoinCpbRoleType : Begin.");
		List<CpbRoleJoinCpbRoleType> result = new ArrayList<CpbRoleJoinCpbRoleType>();
		HttpHeaders responseHeaders = new HttpHeaders();
		try {
			result = cpbRoleService.getAllCpbRoleJoinCpbRoleType();
			log.info("(SUCCESS) Controller cpb_role/allCpbRoleJoinCpbRoleType call success.");
			responseHeaders.add("HeaderResponse", "Web Service OK.");
			return new ResponseEntity<List<CpbRoleJoinCpbRoleType>>(result, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			log.error("(ERROR) Controller cpb_role/allCpbRoleJoinCpbRoleType error. : "+e);
			responseHeaders.add("HeaderResponse", "Web Service ERROR.");
			return new ResponseEntity<List<CpbRoleJoinCpbRoleType>>(result, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
