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
public class LogoutControllerTest {

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
	
	@Test
	public void logoutAppWithProcIsSuccessTest() throws Exception {
		/***********************
		 * Integration Testing
		 ************************/
		// prepare data and mock's behaviour
		
		// execute
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/login_app/logout_proc")
				.contentType(MediaType.APPLICATION_JSON)
				.header("token", uuidToken_true)
				)
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.resultCode").value(LOGOUT_SUCCESS_CODE));
	}
	
	@Test
	public void logoutAppWithProcTokenFalseIsFalseTest() throws Exception {
		/***********************
		 * Integration Testing
		 ************************/
		// prepare data and mock's behaviour
		
		// execute
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/login_app/logout_proc")
				.contentType(MediaType.APPLICATION_JSON)
				.header("token", uuidToken_false)
				)
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.resultCode").value(LOGOUT_FAILED_CODE));
	}
	
	@Test
	public void logoutAppWithProcTokenEmptyIsFalseTest() throws Exception {
		/***********************
		 * Integration Testing
		 ************************/
		// prepare data and mock's behaviour
		
		// execute
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/login_app/logout_proc")
				.contentType(MediaType.APPLICATION_JSON)
				.header("token", uuidToken_empty)
				)
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.resultCode").value(LOGOUT_FAILED_CODE));
	}
	
	@Test
	public void logoutAppWithProcTokenSpaceIsFalseTest() throws Exception {
		/***********************
		 * Integration Testing
		 ************************/
		// prepare data and mock's behaviour
		
		// execute
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/login_app/logout_proc")
				.contentType(MediaType.APPLICATION_JSON)
				.header("token", uuidToken_space)
				)
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.resultCode").value(LOGOUT_FAILED_CODE));
	}
}
