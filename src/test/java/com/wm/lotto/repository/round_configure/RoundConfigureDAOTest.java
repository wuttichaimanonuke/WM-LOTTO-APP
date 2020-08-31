package com.wm.lotto.repository.round_configure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wm.lotto.entity.round_configure.RoundConfigure;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RoundConfigureDAOTest {

	@Autowired
	private IRoundConfigureDAO roundConfigureDAO;

	@Autowired
	private RoundConfigureDAO mockRoundConfigureDAO;

	@Before
	public void setup() {
		setupRoundConfigureDAO();
	}

	private void setupRoundConfigureDAO() {
		mockRoundConfigureDAO = mock(RoundConfigureDAO.class);

	}

	@Test
	public void checkGetCurrentActiveRoundConfigureOk() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		RoundConfigure objExpected  = new RoundConfigure();
		objExpected.setRcfId("20160202");
		objExpected.setrStatus("ACTIVE");
		objExpected.setrYear(2016);
		objExpected.setrMonth(2);
		objExpected.setrRound(2);
		// given
		List<RoundConfigure> dataInList = new ArrayList<RoundConfigure>();
		dataInList.add(objExpected);
		// when
		RoundConfigureDAO configureDAO = mock(RoundConfigureDAO.class);
		when(configureDAO.getCurrentActiveRoundConfigure()).thenReturn(dataInList);
		List<RoundConfigure> result = new ArrayList<RoundConfigure>();
		result = configureDAO.getCurrentActiveRoundConfigure();
		// then
		assertThat(result.size()).isEqualTo(1);
	}

	@Test
	public void checkGetCurrentActiveRoundConfigureNotFound() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		// given
		List<RoundConfigure> emptyInList = new ArrayList<RoundConfigure>();
		// when
		RoundConfigureDAO configureDAO = mock(RoundConfigureDAO.class);
		when(configureDAO.getCurrentActiveRoundConfigure()).thenReturn(emptyInList);
		List<RoundConfigure> result = new ArrayList<RoundConfigure>();
		result = configureDAO.getCurrentActiveRoundConfigure();
		// then
		assertThat(result.isEmpty()).isEqualTo(true);
	}
	
	@Test
	public void checkGetCurrentActiveRoundConfigureDataOver() throws Exception {
		/***********************
		 * Unit Testing
		 ************************/
		// prepare data and mock's behaviour
		RoundConfigure objExpected  = new RoundConfigure();
		objExpected.setRcfId("20160202");
		objExpected.setrStatus("ACTIVE");
		objExpected.setrYear(2016);
		objExpected.setrMonth(2);
		objExpected.setrRound(2);
		// given
		List<RoundConfigure> dataOverInList = new ArrayList<RoundConfigure>();
		dataOverInList.add(objExpected);
		dataOverInList.add(objExpected);
		// when
		RoundConfigureDAO configureDAO = mock(RoundConfigureDAO.class);
		when(configureDAO.getCurrentActiveRoundConfigure()).thenReturn(dataOverInList);
		List<RoundConfigure> result = new ArrayList<RoundConfigure>();
		result = configureDAO.getCurrentActiveRoundConfigure();
		// then
		assertThat(result.size()).isNotEqualTo(1);
	}
}
