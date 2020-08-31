package com.wm.lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mortbay.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.wm.lotto.entity.round_configure.RoundConfigure;
import com.wm.lotto.general.ConstantsResult;
import com.wm.lotto.service.round_configure.IRoundConfigureService;
import com.wm.lotto.service.round_configure.RoundConfigureService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RoundConfigureServiceTest {

	private static final Logger log = LoggerFactory.getLogger(RoundConfigureServiceTest.class);
	
	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
	private IRoundConfigureService roundConfigureService;
	
	@Autowired
	private	RoundConfigureService mockroundConfigureService;
	
	@Before
	public void setup() {
		setupLoginService();
    }
	
	private static final String uuidToken_true = "e365af88-fbee-4976-9477-60bfc9b16aeb";
	private static final String uuidToken_false = "aaaaaaaaaaaaaaaaaaaaa";

	private void setupLoginService() {
		mockroundConfigureService = mock(RoundConfigureService.class);
		
	}
	
	@Test
	public void checkGetCurrentActiveRoundConfigureOk() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		Map<String, Object> objExpected  = new HashMap<String, Object>();
		RoundConfigure resultObjExpected  = new RoundConfigure();
		resultObjExpected.setRcfId("20160202");
		resultObjExpected.setrStatus("ACTIVE");
		resultObjExpected.setrYear(2016);
		resultObjExpected.setrMonth(2);
		resultObjExpected.setrRound(2);
		// given
		objExpected.put("resultCode", ConstantsResult.GET_CURRENT_ACTIVE_ROUNDCONFIG_OK_CODE);
		objExpected.put("resultMessage", ConstantsResult.GET_CURRENT_ACTIVE_ROUNDCONFIG_OK__MSG);
		objExpected.put("result", resultObjExpected);
		// when
		RoundConfigureService mockRoundConfigureService = mock(RoundConfigureService.class);
		when(mockRoundConfigureService.getCurrentActiveRoundConfigure(uuidToken_true)).thenReturn(objExpected);
		Map<String, Object> result = new HashMap<String, Object>();
		result = mockRoundConfigureService.getCurrentActiveRoundConfigure(uuidToken_true);
		// then
		assertThat(result.get("resultCode")).isEqualTo(ConstantsResult.GET_CURRENT_ACTIVE_ROUNDCONFIG_OK_CODE);
	}
	
	@Test
	public void checkGetCurrentActiveRoundConfigureTokenFail() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		Map<String, Object> objExpected  = new HashMap<String, Object>();
		// given
		objExpected.put("resultCode", ConstantsResult.CHECK_TOKEN_IS_EXPIRE_FAIL_CODE);
		objExpected.put("resultMessage", ConstantsResult.CHECK_TOKEN_IS_EXPIRE_FAIL_MSG);
		// when
		RoundConfigureService mockRoundConfigureService = mock(RoundConfigureService.class);
		when(mockRoundConfigureService.getCurrentActiveRoundConfigure(uuidToken_false)).thenReturn(objExpected);
		Map<String, Object> result = new HashMap<String, Object>();
		result = mockRoundConfigureService.getCurrentActiveRoundConfigure(uuidToken_false);
		// then
		assertThat(result.get("resultCode")).isEqualTo(ConstantsResult.CHECK_TOKEN_IS_EXPIRE_FAIL_CODE);
	}
	
	@Test
	public void checkGetCurrentActiveRoundConfigureFailNotFound() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		Map<String, Object> objExpected  = new HashMap<String, Object>();
		// given
		objExpected.put("resultCode", ConstantsResult.GET_CURRENT_ACTIVE_ROUNDCONFIG_FAIL_CODE);
		objExpected.put("resultMessage", ConstantsResult.GET_CURRENT_ACTIVE_ROUNDCONFIG_FAIL_MSG);
		// when
		RoundConfigureService mockRoundConfigureService = mock(RoundConfigureService.class);
		when(mockRoundConfigureService.getCurrentActiveRoundConfigure(uuidToken_true)).thenReturn(objExpected);
		Map<String, Object> result = new HashMap<String, Object>();
		result = mockRoundConfigureService.getCurrentActiveRoundConfigure(uuidToken_true);
		// then
		assertThat(result.get("resultCode")).isEqualTo(ConstantsResult.GET_CURRENT_ACTIVE_ROUNDCONFIG_FAIL_CODE);
	}
	
	@Test
	public void checkGetCurrentActiveRoundConfigureFailDataError() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		Map<String, Object> objExpected  = new HashMap<String, Object>();
		// given
		objExpected.put("resultCode", ConstantsResult.GET_CURRENT_ACTIVE_ROUNDCONFIG_DATAERROR_CODE);
		objExpected.put("resultMessage", ConstantsResult.GET_CURRENT_ACTIVE_ROUNDCONFIG_DATAERROR_MSG);
		// when
		RoundConfigureService mockRoundConfigureService = mock(RoundConfigureService.class);
		when(mockRoundConfigureService.getCurrentActiveRoundConfigure(uuidToken_true)).thenReturn(objExpected);
		Map<String, Object> result = new HashMap<String, Object>();
		result = mockRoundConfigureService.getCurrentActiveRoundConfigure(uuidToken_true);
		// then
		assertThat(result.get("resultCode")).isEqualTo(ConstantsResult.GET_CURRENT_ACTIVE_ROUNDCONFIG_DATAERROR_CODE);
	}
}
