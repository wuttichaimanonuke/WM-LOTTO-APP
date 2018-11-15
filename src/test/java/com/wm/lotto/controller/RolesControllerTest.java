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
import com.wm.lotto.entity.general.RequestDataEntity;
import com.wm.lotto.entity.users.Users;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RolesControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void getAllRolesIsActiveByUidTest() throws Exception {
		/***********************
		 * Integration Testing
		 ************************/
		// prepare data and mock's behaviour
		List<Users> mockListLoginUser = new ArrayList<Users>();
		Users mockLoginUsers = new Users();
		mockLoginUsers.setuId("U05");
		mockListLoginUser.add(mockLoginUsers);
		RequestDataEntity<Users> seriesValue = new RequestDataEntity<Users>();
		seriesValue.setToken("7a4b758e-cc2e-4ff4-9e52-7ba07520c168");
		seriesValue.setDataValue(mockListLoginUser);
		Gson gson = new Gson();
		String jsonBodyContent = gson.toJson(seriesValue);
		
		// execute
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/roles/getAllRolesIsActiveByUserId")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonBodyContent)
				)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
				.andDo(print());
	}
}
