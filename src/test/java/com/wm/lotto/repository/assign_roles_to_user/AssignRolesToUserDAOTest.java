package com.wm.lotto.repository.assign_roles_to_user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wm.lotto.entity.assign_roles_to_user.AssignRolesToUser;

public class AssignRolesToUserDAOTest {
	/*########################
	######## Unit Test #######
	##########################*/
	private static final Logger log = LoggerFactory.getLogger(AssignRolesToUserDAOTest.class);
	
	@Test
	public void getAllAssignRolesToUsersFoundTest() throws Exception {
		log.info("===============================================================");
		log.info("== getAllAssignRolesToUsers() : getAllAssignRolesToUsersFoundTest() Begin ==");
		//given
		List<AssignRolesToUser> hasInList = new ArrayList<AssignRolesToUser>();
		AssignRolesToUser obj = new AssignRolesToUser();
		obj.setAruId(1);
		hasInList.add(obj);
		//when
		AssignRolesToUserDAO assignRolesToUserDAO = mock(AssignRolesToUserDAO.class);
		when(assignRolesToUserDAO.getAllAssignRolesToUsers()).thenReturn(hasInList);
		List<AssignRolesToUser> result = new ArrayList<AssignRolesToUser>();
		result = assignRolesToUserDAO.getAllAssignRolesToUsers();
		//then
		log.info("[ result.isEmpty() = {} ], [ result.size() = {} ], [ result.get(0) = {} ]", result.isEmpty(), result.size(), result.get(0).toString());
		assertThat(result.isEmpty())
			.isEqualTo(false);
		log.info("== End ==");
		log.info("===============================================================");
	}

	@Test
	public void getAllAssignRolesToUsersNotFoundTest() throws Exception {
		log.info("===============================================================");
		log.info("== getAllAssignRolesToUsers() : getAllAssignRolesToUsersNotFoundTest() Begin ==");
		//given
		List<AssignRolesToUser> emptyInList = new ArrayList<AssignRolesToUser>();
		//when
		AssignRolesToUserDAO assignRolesToUserDAO = mock(AssignRolesToUserDAO.class);
		when(assignRolesToUserDAO.getAllAssignRolesToUsers()).thenReturn(emptyInList);
		List<AssignRolesToUser> result = new ArrayList<AssignRolesToUser>();
		result = assignRolesToUserDAO.getAllAssignRolesToUsers();
		//then
		log.info("[ result.isEmpty() = {} ], [ result.size() = {} ]", result.isEmpty(), result.size());
		assertThat(result.isEmpty())
			.isEqualTo(true);
		log.info("== End ==");
		log.info("===============================================================");
	}
}
