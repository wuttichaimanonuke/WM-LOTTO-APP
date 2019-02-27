package com.wm.lotto.service.token;

public interface ITokenService {

	boolean checkThisToken(String token);

	boolean checkThisTokenByTkUid(String token, String uId);
	
	String checkTokenIsExpire(String token);
}
