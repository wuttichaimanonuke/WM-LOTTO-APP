package com.wm.lotto.repository;

import java.util.List;

import com.wm.lotto.entity.TokenLogin;

public interface ITokenLoginDAO {

	List<TokenLogin> getAllTokenLogins();

	TokenLogin getTokenLoginByUserId(String userId);

	void delectTokenLoginByUserId(String userId);

	void insertTokenLogin(TokenLogin tokenLogin);

}
