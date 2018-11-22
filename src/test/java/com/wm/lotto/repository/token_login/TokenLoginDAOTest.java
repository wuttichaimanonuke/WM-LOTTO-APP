package com.wm.lotto.repository.token_login;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wm.lotto.entity.token_login.TokenLogin;

public class TokenLoginDAOTest {
	/*########################
	######## Unit Test #######
	##########################*/
	private static final Logger log = LoggerFactory.getLogger(TokenLoginDAOTest.class);
	
	@Test
	public void getAllTokenLoginsFoundTest() throws Exception {
		log.info("===============================================================");
		log.info("== getAllTokenLogins() : getAllTokenLoginsFoundTest() Begin ==");
		//given
		List<TokenLogin> hasInList = new ArrayList<TokenLogin>();
		TokenLogin obj = new TokenLogin();
		obj.setTlToken("abc-token");;
		hasInList.add(obj);
		//when
		TokenLoginDAO tokenLoginDAO = mock(TokenLoginDAO.class);
		when(tokenLoginDAO.getAllTokenLogins()).thenReturn(hasInList);
		List<TokenLogin> result = new ArrayList<TokenLogin>();
		result = tokenLoginDAO.getAllTokenLogins();
		//then
		log.info("[ result.isEmpty() = {} ], [ result.size() = {} ], [ result.get(0) = {} ]", result.isEmpty(), result.size(), result.get(0).toString());
		assertThat(result.isEmpty())
			.isEqualTo(false);
		log.info("== End ==");
		log.info("===============================================================");
	}

	@Test
	public void getAllTokenLoginsNotFoundTest() throws Exception {
		log.info("===============================================================");
		log.info("== getAllTokenLogins() : getAllTokenLoginsNotFoundTest() Begin ==");
		//given
		List<TokenLogin> emptyInList = new ArrayList<TokenLogin>();
		//when
		TokenLoginDAO tokenLoginDAO = mock(TokenLoginDAO.class);
		when(tokenLoginDAO.getAllTokenLogins()).thenReturn(emptyInList);
		List<TokenLogin> result = new ArrayList<TokenLogin>();
		result = tokenLoginDAO.getAllTokenLogins();
		//then
		log.info("[ result.isEmpty() = {} ], [ result.size() = {} ]", result.isEmpty(), result.size());
		assertThat(result.isEmpty())
			.isEqualTo(true);
		log.info("== End ==");
		log.info("===============================================================");
	}
	
	// ==========================================================
	@Test
	public void getTokenLoginByUserIdFound() throws Exception {
		log.info("===============================================================");
		log.info("== getTokenLoginByUserId() : getTokenLoginByUserIdFound() Begin ==");
		// given
		String userId = "U01";
		TokenLogin tokenLogin = new TokenLogin();
		tokenLogin.setTlToken("7a4b758e-cc2e-4ff4-9e52-7ba07520c168");
		// when
		TokenLoginDAO tokenLoginDAO = mock(TokenLoginDAO.class);
		when(tokenLoginDAO.getTokenLoginByUserId(userId)).thenReturn(tokenLogin);
		TokenLogin result = new TokenLogin();
		result = tokenLoginDAO.getTokenLoginByUserId(userId);
		// then
		log.info("[ result.toString = {} ]", result.toString());
		assertThat(result.getTlToken()).isEqualTo("7a4b758e-cc2e-4ff4-9e52-7ba07520c168");
		log.info("== End ==");
		log.info("===============================================================");
	}

	@Test
	public void getTokenLoginByUserIdNotFound() throws Exception {
		log.info("===============================================================");
		log.info("== getTokenLoginByUserId() : getTokenLoginByUserIdNotFound() Begin ==");
		// given
		String userId = "U01";
		TokenLogin tokenLogin = new TokenLogin();
		// when
		TokenLoginDAO tokenLoginDAO = mock(TokenLoginDAO.class);
		when(tokenLoginDAO.getTokenLoginByUserId(userId)).thenReturn(tokenLogin);
		TokenLogin result = new TokenLogin();
		result = tokenLoginDAO.getTokenLoginByUserId(userId);
		// then
		log.info("[ result.toString = {} ]", result.toString());
		assertThat(result.getTlToken()).isEqualTo(null);
		log.info("== End ==");
		log.info("===============================================================");
	}
	
	// ==========================================================
	@Test
	public void getTokenLoginByTokenFound() throws Exception {
		log.info("===============================================================");
		log.info("== getTokenLoginByToken() : getTokenLoginByTokenFound() Begin ==");
		// given
		String token = "7a4b758e-cc2e-4ff4-9e52-7ba07520c168";
		TokenLogin tokenLogin = new TokenLogin();
		tokenLogin.setTlToken("7a4b758e-cc2e-4ff4-9e52-7ba07520c168");
		// when
		TokenLoginDAO tokenLoginDAO = mock(TokenLoginDAO.class);
		when(tokenLoginDAO.getTokenLoginByToken(token)).thenReturn(tokenLogin);
		TokenLogin result = new TokenLogin();
		result = tokenLoginDAO.getTokenLoginByToken(token);
		// then
		log.info("[ result.toString = {} ]", result.toString());
		assertThat(result.getTlToken()).isEqualTo("7a4b758e-cc2e-4ff4-9e52-7ba07520c168");
		log.info("== End ==");
		log.info("===============================================================");
	}

	@Test
	public void getTokenLoginByTokenNotFound() throws Exception {
		log.info("===============================================================");
		log.info("== getTokenLoginByToken() : getTokenLoginByTokenNotFound() Begin ==");
		// given
		String token = "7a4b758e-cc2e-4ff4-9e52-7ba07520c168";
		TokenLogin tokenLogin = new TokenLogin();
		// when
		TokenLoginDAO tokenLoginDAO = mock(TokenLoginDAO.class);
		when(tokenLoginDAO.getTokenLoginByToken(token)).thenReturn(tokenLogin);
		TokenLogin result = new TokenLogin();
		result = tokenLoginDAO.getTokenLoginByToken(token);
		// then
		log.info("[ result.toString = {} ]", result.toString());
		assertThat(result.getTlToken()).isEqualTo(null);
		log.info("== End ==");
		log.info("===============================================================");
	}
}
