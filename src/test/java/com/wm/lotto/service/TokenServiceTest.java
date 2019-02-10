package com.wm.lotto.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.wm.lotto.service.token.ITokenService;
import com.wm.lotto.service.token.TokenService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TokenServiceTest {

	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
	private ITokenService tokenService;
	
	@Autowired
	private TokenService mockTokenService;
	
	@Before
	public void setup() {
		setupTokenService();
    }
	
	private void setupTokenService() {
		mockTokenService = mock(TokenService.class);
		when(mockTokenService.checkThisTokenByTkUid("7a4b758e-cc2e-4ff4-9e52-7ba07520c168", "U01"))
			.thenReturn(true);
		when(mockTokenService.checkThisTokenByTkUid("7a4b758e-cc2e-4ff4-9e52-7ba07520c168", "U99"))
		.thenReturn(false);
	}
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void checkInputTokenNull() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		String token = null;
		String uId = "U01";
		// execute
		boolean result = tokenService.checkThisTokenByTkUid(token, uId);
		assertEquals(false, result);
	}
	
	@Test
	public void checkInputTokenEmpty() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		String token = "";
		String uId = "U01";
		// execute
		boolean result = tokenService.checkThisTokenByTkUid(token, uId);
		assertEquals(false, result);
	}
	
	@Test
	public void checkInputUidNull() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		String token = "7a4b758e-cc2e-4ff4-9e52-7ba07520c168";
		String uId = null;
		// execute
		boolean result = tokenService.checkThisTokenByTkUid(token, uId);
		assertEquals(false, result);
	}
	
	@Test
	public void checkInputUidEmpty() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		String token = "7a4b758e-cc2e-4ff4-9e52-7ba07520c168";
		String uId = "";
		// execute
		boolean result = tokenService.checkThisTokenByTkUid(token, uId);
		assertEquals(false, result);
	}
	
	@Test
	public void checkInputUidFound() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		String token = "7a4b758e-cc2e-4ff4-9e52-7ba07520c168";
		String uId = "U01";
		// execute
		boolean result = mockTokenService.checkThisTokenByTkUid(token, uId);
		assertEquals(true, result);
	}
	
	@Test
	public void checkInputUidNotFound() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		String token = "7a4b758e-cc2e-4ff4-9e52-7ba07520c168";
		String uId = "U99";
		// execute
		boolean result = mockTokenService.checkThisTokenByTkUid(token, uId);
		assertEquals(false, result);
	}
}
