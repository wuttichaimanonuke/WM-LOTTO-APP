package com.wm.lotto.service.login;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wm.lotto.entity.general.LoginUser;
import com.wm.lotto.entity.token_login.TokenLogin;
import com.wm.lotto.entity.users.Users;
import com.wm.lotto.repository.token_login.ITokenLoginDAO;
import com.wm.lotto.repository.users.IUsersDAO;

@Service
public class LoginService implements ILoginService {

	private static final Logger log = LoggerFactory.getLogger(LoginService.class);
	
	@Autowired
	private IUsersDAO usersDAO;
	
	@Autowired
	private ITokenLoginDAO tokenLoginDAO;

	@Override
	public TokenLogin login(LoginUser loginUser) {
		log.info("(SERVICE) Service login begin.");
		TokenLogin resultUuidToken = new TokenLogin();
		String userId = null;
		Users user = new Users();
		log.info("User ("+loginUser.getUsername()+") is request login.");
		if (loginUser != null) {
			user.setuUsername(loginUser.getUsername());
			user.setuPassword(loginUser.getPassword());
			try {
				userId = usersDAO.checkUserLogin(user);
				log.info("User ("+userId+") is found.");
			} catch (Exception e) {
				log.info("User ("+userId+") is't found.");
				log.error("ERROR ("+user.getuUsername()+") : UsersDAO : checkUserLogin : "+e.getMessage());
			}
			if (userId != null) {
//				check has token of user in Table TokenLogin.
//				IF (TRUE) has token of user in table TokenLogin then Delete old token.
				TokenLogin tokenLogin = new TokenLogin();
				try {
					tokenLogin = tokenLoginDAO.getTokenLoginByUserId(userId);
					if (tokenLogin != null) {
						log.info("User ("+userId+") is still live in system. Do it clear old token.");
						try {
							tokenLoginDAO.delectTokenLoginByUserId(tokenLogin.getUId());
							log.info("Clear token user ("+userId+") success.");
						} catch (Exception e) {
							log.info("Clear token user ("+userId+") fail. : "+e.getMessage());
						}
					} else {
						log.info("User ("+userId+") is't live in system.");
					}
				} catch (Exception e) {
					log.error("ERROR : LoginService : login : "+e.getMessage());
				}
//				Insert new token.
				UUID uuid = UUID.randomUUID();
				tokenLogin = new TokenLogin();
				tokenLogin.setTlToken(uuid.toString());
				tokenLogin.setUId(userId);
				try {
					tokenLoginDAO.insertTokenLogin(tokenLogin);
					log.info("User ("+userId+") login success.");
					resultUuidToken.setTlToken(tokenLogin.getTlToken());
					log.info("Token = "+tokenLogin.getTlToken());
				} catch (Exception e) {
					log.info("User ("+userId+") login fail. : "+e.getMessage());
				}
			}
		}
		return resultUuidToken;
	}

}
