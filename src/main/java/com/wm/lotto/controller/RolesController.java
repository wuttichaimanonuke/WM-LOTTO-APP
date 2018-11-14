package com.wm.lotto.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wm.lotto.entity.general.RequestDataEntity;
import com.wm.lotto.entity.roles.Roles;
import com.wm.lotto.entity.users.Users;
import com.wm.lotto.service.roles.IRolesService;

@RestController
@RequestMapping("roles")
public class RolesController {
	
	private static final Logger log = LoggerFactory.getLogger(RolesController.class);
	
	@Autowired
	private IRolesService rolesService;

	@RequestMapping(value = "/getAllRolesIsActiveByUserId", method = RequestMethod.POST)
	public ResponseEntity<?> getAllRolesIsActiveByUid(@RequestBody RequestDataEntity<Users> seriesValue) {
		log.info("(POST) mapping to getAllRolesIsActiveByUserId : Begin.");
		log.info("@RequestBody : token = {}, dataValue = {}", seriesValue.getToken(),seriesValue.getDataValue());
		Users user = seriesValue.getDataValue().get(0);
		log.info("uId = {}",user.getuId());
		
		List<Roles> resultRoles = new ArrayList<Roles>();
		try {
			resultRoles = rolesService.getAllRolesIsActiveByUid(user);
			log.info("Service return list of Role = {}",resultRoles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Roles>>(resultRoles, HttpStatus.OK);
	}

}
