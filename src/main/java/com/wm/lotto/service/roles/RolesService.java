package com.wm.lotto.service.roles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wm.lotto.entity.roles.Roles;
import com.wm.lotto.entity.users.Users;
import com.wm.lotto.repository.roles.IRolesDAO;
import com.wm.lotto.service.token.ITokenService;

@Service
public class RolesService implements IRolesService {

	private static final Logger log = LoggerFactory.getLogger(RolesService.class);
	
	@Autowired
	private IRolesDAO rolesDAO;
	
	@Autowired
	private ITokenService tokenService;

	@Override
	public List<Roles> getAllRolesIsActiveByUid(Users user) {
		log.info("(SERVICE) Service getAllRolesIsActiveByUid begin.");
		List<Roles> resultRoles = new ArrayList<Roles>();
		log.info("User Id ( {} ) get our roles is active.",user.getuId());
		if (!user.equals(null)) {
			if ( (!user.getuId().isEmpty()) && (!user.getuId().equals(null)) ) {
				try {
					resultRoles = rolesDAO.getAllRolesIsActiveByUid(user.getuId());
					log.info("User ( {} ) has roles.",user.getuId());
				} catch (Exception e) {
					log.info("User ( {} ) can't get roles.",user.getuId());
					log.info("ERROR user ( {} ) RolesDAO : getAllRolesIsActiveByUid : {} ",user.getuId() ,e.getMessage());
				}
			}
		}
		return resultRoles;
	}

	@Override
	public List<Roles> getAllRolesIsActiveByUid(String token, Users user) {
		log.info("(SERVICE) Service getAllRolesIsActiveByUid begin.");
		boolean hasToken = tokenService.checkThisToken(token);
		List<Roles> resultRoles = new ArrayList<Roles>();
		log.info("Check Token Service return result[{}].",hasToken);
		if (hasToken) {
			log.info("User Id ( {} ) get our roles is active.",user.getuId());
			if ( (!user.getuId().isEmpty()) && (!user.getuId().equals(null)) ) {
				try {
					resultRoles = rolesDAO.getAllRolesIsActiveByUid(user.getuId());
					log.info("User ( {} ) has roles.",user.getuId());
				} catch (Exception e) {
					log.info("User ( {} ) can't get roles.",user.getuId());
					log.info("ERROR user ( {} ) RolesDAO : getAllRolesIsActiveByUid : {} ",user.getuId() ,e.getMessage());
				}
			}
		} else {
			log.info("User [{}] is take wrong token.",user.getuId());
		}
		return resultRoles;
	}
	
	
}
