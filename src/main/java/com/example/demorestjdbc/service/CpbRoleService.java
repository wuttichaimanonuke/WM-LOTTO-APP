package com.example.demorestjdbc.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demorestjdbc.entity.CpbRole;
import com.example.demorestjdbc.entity.CpbRoleJoinCpbRoleType;
import com.example.demorestjdbc.repository.ICpbRoleDAO;

@Service
public class CpbRoleService implements ICpbRoleService {

	private static final Logger log = LoggerFactory.getLogger(CpbRoleService.class);
	
	@Autowired
	private ICpbRoleDAO cpbRoleDAO;

	@Override
	public List<CpbRole> getRoleByUserId(Long userId) throws Exception {
		log.info("(SERVICE) Service getRoleByUserId begin.");
		List<CpbRole> result = new ArrayList<CpbRole>();
		try {
			result = cpbRoleDAO.getRoleByUserId(userId);
			log.info("(SUCCESS) Method getRoleByUserId call cpbRoleDAO.getRoleByUserId(userId) success.");
		} catch (Exception e) {
			log.error("(ERROR) Method getRoleByUserId error. : "+e);
			throw new Exception();
		}
		return result;
	}

	@Override
	public List<CpbRoleJoinCpbRoleType> getAllCpbRoleJoinCpbRoleType() throws Exception {
		log.info("(SERVICE) Service getRoleByUserId begin.");
		List<CpbRoleJoinCpbRoleType> result = new ArrayList<CpbRoleJoinCpbRoleType>();
		try {
			result = cpbRoleDAO.getAllCpbRoleJoinCpbRoleType();
			log.info("(SUCCESS) Method getAllCpbRoleJoinCpbRoleType call cpbRoleDAO.getAllCpbRoleJoinCpbRoleType() success.");
		} catch (Exception e) {
			log.error("(ERROR) Method getAllCpbRoleJoinCpbRoleType error. : "+e);
			throw new Exception();
		}
		return result;
	}
	
}
