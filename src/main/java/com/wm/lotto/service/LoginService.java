package com.wm.lotto.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wm.lotto.entity.LoginUser;
import com.wm.lotto.repository.IUsersDAO;

@Service
public class LoginService implements ILoginService {

	private static final Logger log = LoggerFactory.getLogger(LoginService.class);
	
	@Autowired
	private IUsersDAO usersDAO;
	
	public LoginService() {
		super();
	}

	@Override
	public String login(LoginUser loginUser) throws Exception {
		log.info("(SERVICE) Service login begin.");
		
		return null;
	}

}
