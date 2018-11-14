package com.wm.lotto.repository.token_login;

import java.util.List;

import com.wm.lotto.entity.token_login.TokenLogin;

public interface ITokenLoginDAO {

	List<TokenLogin> getAllTokenLogins();

	TokenLogin getTokenLoginByUserId(String userId);

	void delectTokenLoginByUserId(String userId);

	void insertTokenLogin(TokenLogin tokenLogin);

}
