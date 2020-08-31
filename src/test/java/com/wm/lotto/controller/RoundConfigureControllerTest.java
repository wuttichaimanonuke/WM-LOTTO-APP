package com.wm.lotto.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

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

import com.wm.lotto.entity.round_configure.RoundConfigure;
import com.wm.lotto.general.ConstantsResult;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RoundConfigureControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
	public void contextLoads() {
	}
	
	private static final String uuidToken_true = "a72edced-6c90-4fa8-b15b-2ea2e0e72b65";
	private static final String uuidToken_false = "aaaaaaaaaaaaaaaaaaaaa";
	
	@Test
	public void getCurrentActiveRoundConfigureIsSuccess() throws Exception {
		/***********************
		 * Integration Testing
		 ************************/
		// prepare data and mock's behaviour
		
		// execute
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/roundConfigure/getCurrentActiveRoundConfigure")
				.contentType(MediaType.APPLICATION_JSON)
				.header("appToken", uuidToken_true)
				)
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.resultCode").value(ConstantsResult.GET_CURRENT_ACTIVE_ROUNDCONFIG_OK_CODE))
				.andExpect(MockMvcResultMatchers.jsonPath("$.result").isNotEmpty());
	}
	
	@Test
	public void getCurrentActiveRoundConfigureIsTokenFail() throws Exception {
		/***********************
		 * Integration Testing
		 ************************/
		// prepare data and mock's behaviour
		RoundConfigure resultRoundConfigure = new RoundConfigure();
		// execute
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/roundConfigure/getCurrentActiveRoundConfigure")
				.contentType(MediaType.APPLICATION_JSON)
				.header("appToken", uuidToken_false)
				)
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.resultCode").value(ConstantsResult.CHECK_TOKEN_IS_EXPIRE_FAIL_CODE));
	}
}
