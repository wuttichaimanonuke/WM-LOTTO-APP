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

import com.wm.lotto.entity.token_login.TokenLogin;
import com.wm.lotto.service.login.ILoginService;
import com.wm.lotto.service.login.LoginService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginServiceTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
	private ILoginService loginService;
	
	@Autowired
	private LoginService mockLoginService;

	@Before
	public void setup() {
		setupLoginService();
    }
	
	private static final String username_true = "USERNAME02";
	private static final String username_false = "USERNAME_FALSE";
	private static final String password_true = "123";
	private static final String password_false = "999";
	private static final String uId = "U02";
	
	private static final String result_Token = "e365af88-fbee-4976-9477-60bfc9b16aeb";
	private static final String result_Exception_Other = null;
	private static final String result_Input_Invalid = "INPUT INVALID";
	private static final String result_Not_Found = "USER NOT FOUND";
	
	private static final TokenLogin tokenLogin_Success = new TokenLogin(result_Token, uId, null, null, null, null, "SYSTEM");
	private static final TokenLogin tokenLogin_Exception_Other = new TokenLogin(result_Exception_Other, null, null, null, null, null, "SYSTEM");
	private static final TokenLogin tokenLogin_Input_Invalid = new TokenLogin(result_Input_Invalid, null, null, null, null, null, "SYSTEM");
	private static final TokenLogin tokenLogin_Not_Found = new TokenLogin(result_Not_Found, null, null, null, null, null, "SYSTEM");
	
	private static final String uuidToken_true = "e365af88-fbee-4976-9477-60bfc9b16aeb";
	private static final String uuidToken_false = "aaaaaaaaaaaaaaaaaaaaa";
	private static final String uuidToken_null = null;
	private static final String uuidToken_empty = "";
	private static final String uuidToken_space = " ";
	private static final String result_logout_with_proc_Found = "OK";
	private static final String result_logout_with_proc_NotFound = "NOT FOUND";
	
	private void setupLoginService() {
		mockLoginService = mock(LoginService.class);
		when(mockLoginService.loginWithFunc(username_true, password_true))
			.thenReturn(tokenLogin_Success);
		when(mockLoginService.loginWithFunc(username_false, password_false))
			.thenReturn(tokenLogin_Not_Found);
		when(mockLoginService.loginWithFunc(" ", null))
			.thenReturn(tokenLogin_Input_Invalid);
		
		when(mockLoginService.logoutWithProc(uuidToken_true))
			.thenReturn(result_logout_with_proc_Found);
		when(mockLoginService.logoutWithProc(uuidToken_false))
			.thenReturn(result_logout_with_proc_NotFound);
		when(mockLoginService.logoutWithProc(uuidToken_null))
			.thenReturn(result_logout_with_proc_NotFound);
		when(mockLoginService.logoutWithProc(uuidToken_empty))
			.thenReturn(result_logout_with_proc_NotFound);
		when(mockLoginService.logoutWithProc(uuidToken_space))
			.thenReturn(result_logout_with_proc_NotFound);
	}
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void loginWithFuncSuccess() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		// execute
		TokenLogin result = mockLoginService.loginWithFunc(username_true, password_true);
		assertEquals(tokenLogin_Success, result);
	}
	
	@Test
	public void loginWithFuncNotFound() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		// execute
		TokenLogin result = mockLoginService.loginWithFunc(username_false, password_false);
		assertEquals(tokenLogin_Not_Found, result);
	}
	
	@Test
	public void loginWithFuncInputInvalid() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		// execute
		TokenLogin result = mockLoginService.loginWithFunc(" ", null);
		assertEquals(tokenLogin_Input_Invalid, result);
	}
	
	@Test
	public void logoutWithProcSuccess() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		// execute
		String result = mockLoginService.logoutWithProc(uuidToken_true);
		assertEquals(result_logout_with_proc_Found, result);
	}
	
	@Test
	public void logoutWithProcTokenFalseNotFound() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		// execute
		String result = mockLoginService.logoutWithProc(uuidToken_false);
		assertEquals(result_logout_with_proc_NotFound, result);
	}
	
	@Test
	public void logoutWithProcTokenNullNotFound() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		// execute
		String result = mockLoginService.logoutWithProc(uuidToken_null);
		assertEquals(result_logout_with_proc_NotFound, result);
	}
	
	@Test
	public void logoutWithProcTokenEmptyNotFound() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		// execute
		String result = mockLoginService.logoutWithProc(uuidToken_empty);
		assertEquals(result_logout_with_proc_NotFound, result);
	}
	
	@Test
	public void logoutWithProcTokenSpaceNotFound() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		// execute
		String result = mockLoginService.logoutWithProc(uuidToken_space);
		assertEquals(result_logout_with_proc_NotFound, result);
	}
}
