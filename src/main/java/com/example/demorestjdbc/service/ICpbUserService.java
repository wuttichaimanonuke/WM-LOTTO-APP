package com.example.demorestjdbc.service;

import java.util.List;

import com.example.demorestjdbc.entity.CpbUser;

public interface ICpbUserService {
	
	List<CpbUser> getAllCpbUsers() throws Exception;
	List<Long> getAllCpbUserId() throws Exception;
	CpbUser getCpbUserByUserId(long userId) throws Exception;
	Boolean userIdExists(long userId) throws Exception;
	Boolean userLoginExists(String userLogin) throws Exception;
	Boolean fullNameExists(String fullName) throws Exception;
	Boolean eMailExists(String eMail) throws Exception;
}
