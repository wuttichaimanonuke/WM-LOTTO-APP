package com.wm.lotto.service.token;

import org.mortbay.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wm.lotto.entity.token_login.TokenLogin;
import com.wm.lotto.repository.token_login.ITokenLoginDAO;

@Service
public class TokenService implements ITokenService {

	@Autowired
	private ITokenLoginDAO tokenLoginDAO;
	
	@Override
	public boolean checkThisToken(String token) {
		TokenLogin tokenLogin = new TokenLogin();
		if ( !(token.equals(null)) && !(token.trim().equals("")) ) {
			try {
				tokenLogin = tokenLoginDAO.getTokenLoginByToken(token);
				if (!tokenLogin.getTlToken().equals(null)) {
					Log.debug("Service checkThisToken found token[{}] has live in system.",token);
					Log.info("This token[{}] has live in system and result is [{}].", token, tokenLogin.toString());
					return true;
				} else {
					Log.info("This token[{}] has't live in system.", token);
				}
			} catch (Exception e) {
				Log.info("Can't check or not found this token[{}].",token);
			}
		}
		return false;
	}

}
