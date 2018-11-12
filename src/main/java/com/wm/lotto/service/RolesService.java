package com.wm.lotto.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wm.lotto.entity.Roles;
import com.wm.lotto.entity.Users;
import com.wm.lotto.repository.IRolesDAO;

@Service
public class RolesService implements IRolesService {

	private static final Logger log = LoggerFactory.getLogger(RolesService.class);
	
	@Autowired
	private IRolesDAO rolesDAO;

	@Override
	public List<Roles> getAllRolesIsActiveByUid(Users user) {
		log.info("(SERVICE) Service getAllRolesIsActiveByUid begin.");
		List<Roles> resultRoles = new ArrayList<Roles>();
		log.info("User Id ( {} ) get our roles is active.",user.getUId());
		if (!user.equals(null)) {
			if ( (!user.getUId().isEmpty()) && (!user.getUId().equals(null)) ) {
				try {
					resultRoles = rolesDAO.getAllRolesIsActiveByUid(user.getUId());
					log.info("User ( {} ) has roles.",user.getUId());
				} catch (Exception e) {
					log.info("User ( {} ) can't get roles.",user.getUId());
					log.info("ERROR user ( {} ) RolesDAO : getAllRolesIsActiveByUid : {} ",user.getUId() ,e.getMessage());
				}
			}
		}
		return resultRoles;
	}
	
	
}
