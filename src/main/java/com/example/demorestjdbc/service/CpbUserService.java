package com.example.demorestjdbc.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demorestjdbc.entity.CpbUser;
import com.example.demorestjdbc.repository.ICpbUserDAO;

@Service
public class CpbUserService implements ICpbUserService {

	private static final Logger log = LoggerFactory.getLogger(CpbUserService.class);
	
	@Autowired
	private ICpbUserDAO cpbUserDAO;
	
	@Override
	public List<CpbUser> getAllCpbUsers() throws Exception {
		log.info("(SERVICE) Service getAllCpbUsers begin.");
		List<CpbUser> result = new ArrayList<CpbUser>();
		try {
			result = cpbUserDAO.getAllCpbUsers();
			log.info("(SUCCESS) Method getAllCpbUsers call cpbUserDAO.getAllCpbUsers() success.");
		} catch (Exception e) {
			log.error("(ERROR) Method getAllCpbUsers error. : "+e);
			throw new Exception();
		}
		return result;
	}

	@Override
	public List<Long> getAllCpbUserId() throws Exception {
		log.info("(SERVICE) Service getAllCpbUserId begin.");
		List<Long> userIds = new ArrayList<Long>();
		try {
			List<CpbUser> cpbUsers = getAllCpbUsers();
			log.info("(SUCCESS) Method getAllCpbUserId call getAllCpbUsers success.");
			for (CpbUser cpbUser : cpbUsers) {
				userIds.add(cpbUser.getUserId());
			}
		} catch (Exception e) {
			log.error("(ERROR) Method getAllCpbUserId error. : "+e);
			throw new Exception();
		}
		return userIds;
	}

	@Override
	public CpbUser getCpbUserByUserId(long userId) throws Exception {
		log.info("(SERVICE) Service getCpbUserByUserId begin.");
		CpbUser cpbUser = new CpbUser();
		try {
			cpbUser = cpbUserDAO.getCpbUserByUserId(userId);
			log.info("(SUCCESS) Method getCpbUserByUserId call cpbUserDAO.getCpbUserByUserId(userId) success.");
		} catch (Exception e) {
			log.error("(ERROR) Method getCpbUserByUserId error. : "+e);
			throw new Exception();
		}
		return cpbUser;
	}

	@Override
	public Boolean userIdExists(long userId) throws Exception {
		log.info("(SERVICE) Service userIdExists begin.");
		Boolean result;
		try {
			result = cpbUserDAO.userIdExists(userId);
			log.info("(SUCCESS) Method userIdExists call cpbUserDAO.userIdExists(userId) success.");
		} catch (Exception e) {
			log.error("(ERROR) Method userIdExists error. : "+e);
			throw new Exception();
		}
		return result;
	}

	@Override
	public Boolean userLoginExists(String userLogin) throws Exception {
		log.info("(SERVICE) Service userLoginExists begin.");
		Boolean result;
		try {
			result = cpbUserDAO.userLoginExists(userLogin);
			log.info("(SUCCESS) Method userLoginExists call cpbUserDAO.userLoginExists(userLogin) success.");
		} catch (Exception e) {
			log.error("(ERROR) Method userLoginExists error. : "+e);
			throw new Exception();
		}
		return result;
	}

	@Override
	public Boolean fullNameExists(String fullName) throws Exception {
		log.info("(SERVICE) Service fullNameExists begin.");
		Boolean result;
		try {
			result = cpbUserDAO.fullNameExists(fullName);
			log.info("(SUCCESS) Method fullNameExists call cpbUserDAO.fullNameExists(fullName) success.");
		} catch (Exception e) {
			log.error("(ERROR) Method fullNameExists error. : "+e);
			throw new Exception();
		}
		return result;
	}

	@Override
	public Boolean eMailExists(String eMail) throws Exception {
		log.info("(SERVICE) Service eMailExists begin.");
		Boolean result;
		try {
			result = cpbUserDAO.eMailExists(eMail);
			log.info("(SUCCESS) Method eMailExists call cpbUserDAO.eMailExists(eMail) success.");
		} catch (Exception e) {
			log.error("(ERROR) Method eMailExists error. : "+e);
			throw new Exception();
		}
		return result;
	}

}
