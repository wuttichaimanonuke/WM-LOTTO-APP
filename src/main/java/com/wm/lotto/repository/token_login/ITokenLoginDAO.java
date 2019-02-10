package com.wm.lotto.repository.token_login;

import java.util.List;
import java.util.UUID;

import com.wm.lotto.entity.token_login.TokenLogin;

public interface ITokenLoginDAO {

	List<TokenLogin> getAllTokenLogins();

	TokenLogin getTokenLoginByUserId(String userId);

	void delectTokenLoginByUserId(String userId);

	void insertTokenLogin(TokenLogin tokenLogin);
	
	TokenLogin getTokenLoginByToken(String token);

	boolean checkExistThisTokenAndUid(String token, String uId);

	String loginWithFunc(String username, String password, String string);
	
	String logoutWithProc(String uuidToken);

}
