package com.wm.lotto.repository.token_login;

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

import com.wm.lotto.general.ConstantsResultDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TokenLoginDAOTest {

	@Autowired
	private ITokenLoginDAO tokenLoginDAO;
	
	@Autowired
	private TokenLoginDAO mockTokenLoginDAO;
	
	@Before
	public void setup() {
		setupTokenLoginDAO();
    }
	
	private static final String username_true = "USERNAME02";
	private static final String username_false = "USERNAME_FALSE";
	private static final String username_null = null;
	private static final String username_empty = "";
	private static final String username_space = " ";
	private static final String password_true = "123";
	private static final String password_false = "999";
	private static final String password_null = null;
	private static final String password_empty = "";
	private static final String password_space = " ";
	private static final String uuidToken_true = "e365af88-fbee-4976-9477-60bfc9b16aeb";
	private static final String uuidToken_false = "aaaaaaaaaaaaaaaaaaaaa";
	private static final String uuidToken_null = null;
	private static final String uuidToken_empty = "";
	private static final String uuidToken_space = " ";
	private static final String result_Success = uuidToken_true;
	private static final String result_ExceptionOther = null;
	private static final String result_Input_Invalid = "INPUT INVALID";
	private static final String result_Not_Found = "USER NOT FOUND";
	
	private void setupTokenLoginDAO() {
		mockTokenLoginDAO = mock(TokenLoginDAO.class);
		when(mockTokenLoginDAO.checkExistThisTokenAndUid("7a4b758e-cc2e-4ff4-9e52-7ba07520c168", "U01"))
			.thenReturn(true);
		when(mockTokenLoginDAO.checkExistThisTokenAndUid("7a4b758e-cc2e-4ff4-9e52-7ba07520c168", "U99"))
			.thenReturn(false);
		
		when(mockTokenLoginDAO.loginWithFunc(username_true, password_true, uuidToken_true))
			.thenReturn(result_Success);
		when(mockTokenLoginDAO.loginWithFunc(username_null, password_empty, uuidToken_space))
			.thenReturn(result_Input_Invalid);
		when(mockTokenLoginDAO.loginWithFunc(username_false, password_false, uuidToken_true))
			.thenReturn(result_Not_Found);
		
		when(mockTokenLoginDAO.logoutWithProc(uuidToken_true))
			.thenReturn("OK");
		when(mockTokenLoginDAO.logoutWithProc(uuidToken_false))
			.thenReturn("NOT FOUND");
		when(mockTokenLoginDAO.logoutWithProc(uuidToken_null))
			.thenReturn("NOT FOUND");
		when(mockTokenLoginDAO.logoutWithProc(uuidToken_empty))
			.thenReturn("NOT FOUND");
		when(mockTokenLoginDAO.logoutWithProc(uuidToken_space))
			.thenReturn("NOT FOUND");
		
		when(mockTokenLoginDAO.checkTokenIsExpire(uuidToken_true))
			.thenReturn(ConstantsResultDAO.result_checkTokenIsExpir_Ok);
		when(mockTokenLoginDAO.checkTokenIsExpire(uuidToken_false))
			.thenReturn(ConstantsResultDAO.result_checkTokenIsExpir_Fail);
	}

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void checkExistThisTokenAndUidCheckInputTokenNull() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		String token = null;
		String uId = "U01";
		// execute
		boolean result = tokenLoginDAO.checkExistThisTokenAndUid(token, uId);
		assertEquals(false, result);
	}
	
	@Test
	public void checkExistThisTokenAndUidCheckInputTokenEmpty() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		String token = "";
		String uId = "U01";
		// execute
		boolean result = tokenLoginDAO.checkExistThisTokenAndUid(token, uId);
		assertEquals(false, result);
	}
	
	@Test
	public void checkExistThisTokenAndUidCheckInputUidNull() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		String token = "7a4b758e-cc2e-4ff4-9e52-7ba07520c168";
		String uId = null;
		// execute
		boolean result = tokenLoginDAO.checkExistThisTokenAndUid(token, uId);
		assertEquals(false, result);
	}
	
	@Test
	public void checkExistThisTokenAndUidCheckInputUidEmpty() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		String token = "7a4b758e-cc2e-4ff4-9e52-7ba07520c168";
		String uId = "";
		// execute
		boolean result = tokenLoginDAO.checkExistThisTokenAndUid(token, uId);
		assertEquals(false, result);
	}
	
	@Test
	public void checkExistThisTokenAndUidCheckInputUidFound() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		String token = "7a4b758e-cc2e-4ff4-9e52-7ba07520c168";
		String uId = "U01";
		// execute
		boolean result = mockTokenLoginDAO.checkExistThisTokenAndUid(token, uId);
		assertEquals(true, result);
	}
	
	@Test
	public void checkExistThisTokenAndUidCheckInputUidNotFound() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		String token = "7a4b758e-cc2e-4ff4-9e52-7ba07520c168";
		String uId = "U99";
		// execute
		boolean result = mockTokenLoginDAO.checkExistThisTokenAndUid(token, uId);
		assertEquals(false, result);
	}
	
	@Test
	public void loginWithFuncSuccess() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		// execute
		String result = mockTokenLoginDAO.loginWithFunc(username_true, password_true, uuidToken_true);
		assertEquals(result_Success, result);
	}
	
	@Test
	public void loginWithFuncInputInvalid() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		// execute
		String result = mockTokenLoginDAO.loginWithFunc(username_null, password_empty, uuidToken_space);
		assertEquals(ConstantsResultDAO.result_Login_with_func_Input_Invalid, result);
	}
	
	@Test
	public void loginWithFuncNotFound() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		// execute
		String result = mockTokenLoginDAO.loginWithFunc(username_false, password_false, uuidToken_true);
		assertEquals(ConstantsResultDAO.result_Login_with_func_Not_Found, result);
	}
	
	@Test
	public void logoutWithProcSuccess() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		// execute
		String result = mockTokenLoginDAO.logoutWithProc(uuidToken_true);
		assertEquals(ConstantsResultDAO.result_logout_with_proc_Found, result);
	}
	
	@Test
	public void logoutWithProcTokenFalseNotFound() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		// execute
		String result = mockTokenLoginDAO.logoutWithProc(uuidToken_false);
		assertEquals(ConstantsResultDAO.result_logout_with_proc_NotFound, result);
	}
	
	@Test
	public void logoutWithProcTokenNullNotFound() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		// execute
		String result = mockTokenLoginDAO.logoutWithProc(uuidToken_null);
		assertEquals(ConstantsResultDAO.result_logout_with_proc_NotFound, result);
	}
	
	@Test
	public void logoutWithProcTokenEmptyNotFound() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		// execute
		String result = mockTokenLoginDAO.logoutWithProc(uuidToken_empty);
		assertEquals(ConstantsResultDAO.result_logout_with_proc_NotFound, result);
	}
	
	@Test
	public void logoutWithProcTokenSpaceNotFound() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		// execute
		String result = mockTokenLoginDAO.logoutWithProc(uuidToken_space);
		assertEquals(ConstantsResultDAO.result_logout_with_proc_NotFound, result);
	}
	
	@Test
	public void checkTokenIsExpireOk() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		// execute
		String result = mockTokenLoginDAO.checkTokenIsExpire(uuidToken_true);
		assertEquals(ConstantsResultDAO.result_checkTokenIsExpir_Ok, result);
	}
	
	@Test
	public void checkTokenIsExpireFail() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		// execute
		String result = mockTokenLoginDAO.checkTokenIsExpire(uuidToken_false);
		assertEquals(ConstantsResultDAO.result_checkTokenIsExpir_Fail, result);
	}
}
