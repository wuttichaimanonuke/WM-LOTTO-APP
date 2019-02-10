package com.wm.lotto.service.login;

import com.wm.lotto.entity.general.LoginUser;
import com.wm.lotto.entity.token_login.TokenLogin;

public interface ILoginService {
	TokenLogin login(LoginUser loginUser);

	TokenLogin loginWithFunc(String username, String password);
	
	String logoutWithProc(String uuidtoken);
}
