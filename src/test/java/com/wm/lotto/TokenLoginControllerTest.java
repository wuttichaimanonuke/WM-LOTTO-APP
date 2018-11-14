package com.wm.lotto;

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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;

import com.wm.lotto.entity.general.RequestDataEntity;
import com.wm.lotto.service.token.TokenService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TokenLoginControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
	private TokenService tokenService;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void checkThisTokenTest() throws Exception {
		// prepare data and mock's behaviour
		RequestDataEntity<String> seriesValue = new RequestDataEntity<String>();
		seriesValue.setToken("7a4b758e-cc2e-4ff4-9e52-7ba07520c168");
		seriesValue.setDataValue(null);
		Gson gson = new Gson();
		String jsonBodyContent = gson.toJson(seriesValue);
		
		// execute
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/tokenlogin/chekThisToken")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonBodyContent)
				)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(true));
	}
}
