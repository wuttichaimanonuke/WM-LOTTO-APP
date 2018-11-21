package com.wm.lotto.repository.roles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wm.lotto.entity.roles.Roles;
import com.wm.lotto.entity.users.Users;
import com.wm.lotto.repository.users.UsersDAO;

public class RolesDAOTest {
	/*########################
	######## Unit Test #######
	##########################*/
	private static final Logger log = LoggerFactory.getLogger(RolesDAOTest.class);
	
	@Test
	public void getAllRolesFoundTest() throws Exception {
		log.info("===============================================================");
		log.info("== getAllRoles() : getAllRolesFoundTest() Begin ==");
		//given
		List<Roles> hasInList = new ArrayList<Roles>();
		Roles obj = new Roles();
		obj.setRId(1);;
		hasInList.add(obj);
		//when
		RolesDAO rolesDAO = mock(RolesDAO.class);
		when(rolesDAO.getAllRoles()).thenReturn(hasInList);
		List<Roles> result = new ArrayList<Roles>();
		result = rolesDAO.getAllRoles();
		//then
		log.info("[ result.isEmpty() = {} ], [ result.size() = {} ], [ result.get(0) = {} ]", result.isEmpty(), result.size(), result.get(0).toString());
		assertThat(result.isEmpty())
			.isEqualTo(false);
		log.info("== End ==");
		log.info("===============================================================");
	}

	@Test
	public void getAllRolesNotFoundTest() throws Exception {
		log.info("===============================================================");
		log.info("== getAllRoles() : getAllRolesNotFoundTest() Begin ==");
		//given
		List<Roles> emptyInList = new ArrayList<Roles>();
		//when
		RolesDAO rolesDAO = mock(RolesDAO.class);
		when(rolesDAO.getAllRoles()).thenReturn(emptyInList);
		List<Roles> result = new ArrayList<Roles>();
		result = rolesDAO.getAllRoles();
		//then
		log.info("[ result.isEmpty() = {} ], [ result.size() = {} ]", result.isEmpty(), result.size());
		assertThat(result.isEmpty())
			.isEqualTo(true);
		log.info("== End ==");
		log.info("===============================================================");
	}
	
	// ==========================================================
	@Test
	public void getAllRolesIsActiveByUidFound() throws Exception {
		log.info("===============================================================");
		log.info("== getAllRolesIsActiveByUid() : getAllRolesIsActiveByUidFound() Begin ==");
		// given
		String uId = "U01";
		List<Roles> hasInList = new ArrayList<Roles>();
		Roles obj = new Roles();
		obj.setRId(1);
		hasInList.add(obj);
		// when
		RolesDAO rolesDAO = mock(RolesDAO.class);
		when(rolesDAO.getAllRolesIsActiveByUid(uId)).thenReturn(hasInList);
		List<Roles> result = new ArrayList<Roles>();
		result = rolesDAO.getAllRolesIsActiveByUid(uId);
		// then
		log.info("[ result.isEmpty() = {} ], [ result.size() = {} ]", result.isEmpty(), result.size());
		assertThat(result.isEmpty())
			.isEqualTo(false);
		log.info("== End ==");
		log.info("===============================================================");
	}

	@Test
	public void getAllRolesIsActiveByUidNotFound() throws Exception {
		log.info("===============================================================");
		log.info("== getAllRolesIsActiveByUid() : getAllRolesIsActiveByUidNotFound() Begin ==");
		// given
		String uId = "U01";
		List<Roles> emptyInList = new ArrayList<Roles>();
		// when
		RolesDAO rolesDAO = mock(RolesDAO.class);
		when(rolesDAO.getAllRolesIsActiveByUid(uId)).thenReturn(emptyInList);
		List<Roles> result = new ArrayList<Roles>();
		result = rolesDAO.getAllRolesIsActiveByUid(uId);
		// then
		log.info("[ result.isEmpty() = {} ], [ result.size() = {} ]", result.isEmpty(), result.size());
		assertThat(result.isEmpty())
			.isEqualTo(true);
		log.info("== End ==");
		log.info("===============================================================");
	}
}
