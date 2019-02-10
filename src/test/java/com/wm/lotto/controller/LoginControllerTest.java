package com.wm.lotto.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.google.gson.Gson;
import com.wm.lotto.entity.general.LoginUser;
import com.wm.lotto.entity.general.RequestDataEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {

	@Autowired
    private MockMvc mockMvc;

	@Test
	public void contextLoads() {
	}
	
	private static final String username_true = "USERNAME02";
	private static final String username_false = "USERNAME_FALSE";
	private static final String password_true = "123";
	private static final String password_false = "999";
	private static final String uId = "U02";
	
	private static final String uuidToken_true = "e365af88-fbee-4976-9477-60bfc9b16aeb";
	private static final String uuidToken_false = "aaaaaaaaaaaaaaaaaaaaa";
	private static final String uuidToken_null = null;
	private static final String uuidToken_empty = "";
	private static final String uuidToken_space = " ";
	private static final String result_logout_with_proc_Found = "OK";
	private static final String result_logout_with_proc_NotFound = "NOT FOUND";
	
	private static final String LOGIN_SUCCESS_CODE = "LOGI200";
	private static final String LOGIN_SUCCESS_MSG = "Login success.";
	private static final String LOGIN_FAILED_CODE = "LOGI204";
	private static final String LOGIN_FAILED_MSG = "Login failed.";
	private static final String LOGIN_NOT_FOUND_CODE = "LOGI404";
	private static final String LOGIN_NOT_FOUND_MSG = "User not found.";
	private static final String LOGIN_INPUT_INVALID_CODE = "LOGI400";
	private static final String LOGIN_INPUT_INVALID_MSG = "Input data invalid.";
	
	private static final String LOGOUT_SUCCESS_CODE = "LOGO200";
	private static final String LOGOUT_SUCCESS_MSG = "Logout success.";
	private static final String LOGOUT_FAILED_CODE = "LOGO204";
	private static final String LOGOUT_FAILED_MSG = "Logout failed.";
	
//	@Test
//	public void loginAppIsSuccessTest() throws Exception {
//		/***********************
//		 * Integration Testing
//		 ************************/
//		// prepare data and mock's behaviour
//		List<LoginUser> mockListLoginUser = new ArrayList<LoginUser>();
//		LoginUser mockLoginUsers = new LoginUser();
//		mockLoginUsers.setUsername("USERNAME01");
//		mockLoginUsers.setPassword("123");
//		mockListLoginUser.add(mockLoginUsers);
//		RequestDataEntity<LoginUser> seriesValue = new RequestDataEntity<LoginUser>();
//		seriesValue.setToken(null);
//		seriesValue.setDataValue(mockListLoginUser);
//		Gson gson = new Gson();
//		String jsonBodyContent = gson.toJson(seriesValue);
//		
//		// execute
//		this.mockMvc.perform(
//				MockMvcRequestBuilders.post("/login_app/login")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(jsonBodyContent)
//				)
//				.andDo(print())
//				.andExpect(MockMvcResultMatchers.status().isFound())
//				.andExpect(MockMvcResultMatchers.jsonPath("$.token").isString())
//				.andExpect(MockMvcResultMatchers.jsonPath("$.uId").isString());
//	}
	
//	@Test
//	public void loginAppIsFailTest() throws Exception {
//		/***********************
//		 * Integration Testing
//		 ************************/
//		// prepare data and mock's behaviour
//		List<LoginUser> mockListLoginUser = new ArrayList<LoginUser>();
//		LoginUser mockLoginUsers = new LoginUser();
//		mockLoginUsers.setUsername("BAD-USERNAME");
//		mockLoginUsers.setPassword("123");
//		mockListLoginUser.add(mockLoginUsers);
//		RequestDataEntity<LoginUser> seriesValue = new RequestDataEntity<LoginUser>();
//		seriesValue.setToken(null);
//		seriesValue.setDataValue(mockListLoginUser);
//		Gson gson = new Gson();
//		String jsonBodyContent = gson.toJson(seriesValue);
//		
//		// execute
//		this.mockMvc.perform(
//				MockMvcRequestBuilders.post("/login_app/login")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(jsonBodyContent)
//				)
//				.andDo(print())
//				.andExpect(MockMvcResultMatchers.status().isNotFound())
//				.andExpect(MockMvcResultMatchers.jsonPath("$.token").isEmpty())
//				.andExpect(MockMvcResultMatchers.jsonPath("$.uId").isEmpty());
//	}
	
	@Test
	public void loginAppWithFuncIsSuccessTest() throws Exception {
		/***********************
		 * Integration Testing
		 ************************/
		// prepare data and mock's behaviour
		
		// execute
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/login_app/login_func")
				.contentType(MediaType.APPLICATION_JSON)
				.header("username", username_true)
				.header("password", password_true)
				)
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.resultCode").value(LOGIN_SUCCESS_CODE))
				.andExpect(MockMvcResultMatchers.jsonPath("$.token").isString())
				.andExpect(MockMvcResultMatchers.jsonPath("$.uId").value(uId));
	}
	
}
