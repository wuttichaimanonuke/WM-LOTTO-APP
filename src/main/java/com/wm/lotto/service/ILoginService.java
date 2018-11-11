package com.wm.lotto.service;

import com.wm.lotto.entity.LoginUser;
import com.wm.lotto.entity.TokenLogin;

public interface ILoginService {
	TokenLogin login(LoginUser loginUser);
}
