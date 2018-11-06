package com.wm.lotto.service;

import com.wm.lotto.entity.LoginUser;

public interface ILoginService {
	String login(LoginUser loginUser) throws Exception;
}
