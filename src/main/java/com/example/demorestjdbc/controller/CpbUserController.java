package com.example.demorestjdbc.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demorestjdbc.entity.CpbRole;
import com.example.demorestjdbc.entity.CpbUser;
import com.example.demorestjdbc.entity.ResultBoolean;
import com.example.demorestjdbc.service.ICpbRoleService;
import com.example.demorestjdbc.service.ICpbUserService;

@RestController
@RequestMapping("cpb_user")
public class CpbUserController {
	
	private static final Logger log = LoggerFactory.getLogger(CpbUserController.class);
	
	@Autowired
	private ICpbUserService cpbUserService;
	
	@Autowired
	private ICpbRoleService cpbRoleService;
	
	@GetMapping("user")
	public ResponseEntity<List<CpbUser>> getAllCpbUesrs() {
		log.info("(GET) mapping to getAllCpbUesrs : Begin.");
		List<CpbUser> result = new ArrayList<CpbUser>();
		HttpHeaders responseHeaders = new HttpHeaders();
		try {
			result = cpbUserService.getAllCpbUsers();
			log.info("(SUCCESS) Controller cpb_user/user call success.");
			responseHeaders.add("HeaderResponse", "Web Service OK.");
			return new ResponseEntity<List<CpbUser>>(result, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			log.error("(ERROR) Controller cpb_user/user error. : "+e);
			responseHeaders.add("HeaderResponse", "Web Service ERROR.");
			return new ResponseEntity<List<CpbUser>>(result, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "allUserId", method = RequestMethod.GET)
	public ResponseEntity<List<Long>> getAllCpbUserId() {
		log.info("(GET) mapping to getAllCpbUserId : Begin.");
		List<Long> result = new ArrayList<Long>();
		HttpHeaders responseHeaders = new HttpHeaders();
		try {
			result = cpbUserService.getAllCpbUserId();
			log.info("(SUCCESS) Controller cpb_user/allUserId call success.");
			responseHeaders.add("HeaderResponse", "Web Service OK.");
			return new ResponseEntity<List<Long>>(result, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			log.error("(ERROR) Controller cpb_user/allUserId error. : "+e);
			responseHeaders.add("HeaderResponse", "Web Service ERROR.");
			return new ResponseEntity<List<Long>>(result, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("userByUserId/{userId}")
	public ResponseEntity<CpbUser> getCpbUserByUserId(@PathVariable("userId") long userId) {
		log.info("(GET) mapping to getCpbUserByUserId : Begin.");
		CpbUser cpbUser = new CpbUser();
		HttpHeaders responseHeaders = new HttpHeaders();
		try {
			cpbUser = cpbUserService.getCpbUserByUserId(userId);
			log.info("(SUCCESS) Controller cpb_user/userByUserId call success.");
			responseHeaders.add("HeaderResponse", "Web Service OK.");
			return new ResponseEntity<CpbUser>(cpbUser, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			log.error("(ERROR) Controller cpb_user/userByUserId error. : "+e);
			responseHeaders.add("HeaderResponse", "Web Service ERROR.");
			return new ResponseEntity<CpbUser>(cpbUser, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("userIdExists/{userId}")
	public ResponseEntity<ResultBoolean> checkUserIdExists(@PathVariable("userId") long userId) {
		log.info("(GET) mapping to checkUserIdExists : Begin.");
		ResultBoolean result = new ResultBoolean();
		HttpHeaders responseHeaders = new HttpHeaders();
		try {
			result.setResult(cpbUserService.userIdExists(userId));
			log.info("(SUCCESS) Controller cpb_user/userIdExists call success.");
			responseHeaders.add("HeaderResponse", "Web Service OK.");
			if (result.isResult()) {
				return new ResponseEntity<ResultBoolean>(result, responseHeaders, HttpStatus.FOUND);
			} else {
				return new ResponseEntity<ResultBoolean>(result, responseHeaders, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			log.error("(ERROR) Controller cpb_user/userIdExists error. : "+e);
			responseHeaders.add("HeaderResponse", "Web Service ERROR.");
			return new ResponseEntity<ResultBoolean>(result, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("userLoginExists/{userLogin}")
	public ResponseEntity<ResultBoolean> checkUserLoginExists(@PathVariable("userLogin") String userLogin) {
		log.info("(GET) mapping to checkUserLoginExists : Begin.");
		ResultBoolean result = new ResultBoolean();
		HttpHeaders responseHeaders = new HttpHeaders();
		try {
			result.setResult(cpbUserService.userLoginExists(userLogin));
			log.info("(SUCCESS) Controller cpb_user/userLoginExists call success.");
			responseHeaders.add("HeaderResponse", "Web Service OK."+userLogin);
			if (result.isResult()) {
				return new ResponseEntity<ResultBoolean>(result, responseHeaders, HttpStatus.FOUND);
			} else {
				return new ResponseEntity<ResultBoolean>(result, responseHeaders, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			log.error("(ERROR) Controller cpb_user/userLoginExists error. : "+e);
			responseHeaders.add("HeaderResponse", "Web Service ERROR.");
			return new ResponseEntity<ResultBoolean>(result, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "userFullNameExists", method = RequestMethod.GET)
	public ResponseEntity<ResultBoolean> checkFullNameExists(@RequestParam("fullName") String fullName) {
		log.info("(GET) mapping to checkFullNameExists : Begin.");
		ResultBoolean result = new ResultBoolean();
		HttpHeaders responseHeaders = new HttpHeaders();
		try {
			result.setResult(cpbUserService.fullNameExists(fullName));
			log.info("(SUCCESS) Controller cpb_user/userFullNameExists call success.");
			responseHeaders.add("HeaderResponse", "Web Service OK.");
			if (result.isResult()) {
				return new ResponseEntity<ResultBoolean>(result, responseHeaders, HttpStatus.FOUND);
			} else {
				return new ResponseEntity<ResultBoolean>(result, responseHeaders, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			log.error("(ERROR) Controller cpb_user/userFullNameExists error. : "+e);
			responseHeaders.add("HeaderResponse", "Web Service ERROR.");
			return new ResponseEntity<ResultBoolean>(result, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "userEMailExists", method = RequestMethod.GET)
	public ResponseEntity<ResultBoolean> checkeMailExists(@RequestParam("eMail") String eMail) {
		log.info("(GET) mapping to checkeMailExists : Begin.");
		ResultBoolean result = new ResultBoolean();
		HttpHeaders responseHeaders = new HttpHeaders();
		try {
			result.setResult(cpbUserService.eMailExists(eMail));
			log.info("(SUCCESS) Controller cpb_user/userEMailExists call success.");
			responseHeaders.add("HeaderResponse", "Web Service OK.");
			if (result.isResult()) {
				return new ResponseEntity<ResultBoolean>(result, responseHeaders, HttpStatus.FOUND);
			} else {
				return new ResponseEntity<ResultBoolean>(result, responseHeaders, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			log.error("(ERROR) Controller cpb_user/userEMailExists error. : "+e);
			responseHeaders.add("HeaderResponse", "Web Service ERROR.");
			return new ResponseEntity<ResultBoolean>(result, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "allRolesOfuser/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<CpbRole>> getAllRolesOfUser(@PathVariable("userId") Long userId) {
		log.info("(GET) mapping to getAllRolesOfUser : Begin.");
		List<CpbRole> result = new ArrayList<CpbRole>();
		HttpHeaders responseHeaders = new HttpHeaders();
		try {
			result = cpbRoleService.getRoleByUserId(userId);
			log.info("(SUCCESS) Controller cpb_user/allRolesOfuser call success.");
			responseHeaders.add("HeaderResponse", "Web Service Ok.");
			return new ResponseEntity<List<CpbRole>>(result, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			log.error("(ERROR) Controller cpb_user/allRolesOfuser error. : "+e);
			responseHeaders.add("HeaderResponse", "Web Service Error.");
			return new ResponseEntity<List<CpbRole>>(result, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
