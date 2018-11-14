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
	
	@Test
	public void loginAppIsSuccessTest() throws Exception {
		/***********************
		 * Integration Testing
		 ************************/
		// prepare data and mock's behaviour
		List<LoginUser> mockListLoginUser = new ArrayList<LoginUser>();
		LoginUser mockLoginUsers = new LoginUser();
		mockLoginUsers.setUsername("USERNAME01");
		mockLoginUsers.setPassword("123");
		mockListLoginUser.add(mockLoginUsers);
		RequestDataEntity<LoginUser> seriesValue = new RequestDataEntity<LoginUser>();
		seriesValue.setToken(null);
		seriesValue.setDataValue(mockListLoginUser);
		Gson gson = new Gson();
		String jsonBodyContent = gson.toJson(seriesValue);
		
		// execute
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/login_app/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonBodyContent)
				)
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.token").isString());
	}
	
	@Test
	public void loginAppIsFailTest() throws Exception {
		/***********************
		 * Integration Testing
		 ************************/
		// prepare data and mock's behaviour
		List<LoginUser> mockListLoginUser = new ArrayList<LoginUser>();
		LoginUser mockLoginUsers = new LoginUser();
		mockLoginUsers.setUsername("BAD-USERNAME");
		mockLoginUsers.setPassword("123");
		mockListLoginUser.add(mockLoginUsers);
		RequestDataEntity<LoginUser> seriesValue = new RequestDataEntity<LoginUser>();
		seriesValue.setToken(null);
		seriesValue.setDataValue(mockListLoginUser);
		Gson gson = new Gson();
		String jsonBodyContent = gson.toJson(seriesValue);
		
		// execute
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/login_app/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonBodyContent)
				)
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.token").isEmpty());
	}
}
