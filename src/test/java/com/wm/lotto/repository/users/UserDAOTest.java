package com.wm.lotto.repository.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wm.lotto.entity.users.Users;

public class UserDAOTest {
	/*########################
	######## Unit Test #######
	##########################*/
	private static final Logger log = LoggerFactory.getLogger(UserDAOTest.class);
	
	@Test
	public void getAllUsersFoundTest() throws Exception {
		log.info("===============================================================");
		log.info("== getAllUsers() : getAllUsersFoundTest() Begin ==");
		//given
		List<Users> hasUserInList = new ArrayList<Users>();
		Users user = new Users();
		user.setuId("U01");
		hasUserInList.add(user);
		//when
		UsersDAO usersDAO = mock(UsersDAO.class);
		when(usersDAO.getAllUsers()).thenReturn(hasUserInList);
		List<Users> result = new ArrayList<Users>();
		result = usersDAO.getAllUsers();
		//then
		log.info("[ result.isEmpty() = {} ], [ result.size() = {} ], [ result.get(0) = {} ]", result.isEmpty(), result.size(), result.get(0).toString());
		assertThat(result.isEmpty())
			.isEqualTo(false);
		log.info("== End ==");
		log.info("===============================================================");
	}

	@Test
	public void getAllUsersNotFoundTest() throws Exception {
		log.info("===============================================================");
		log.info("== getAllUsers() : getAllUsersNotFoundTest() Begin ==");
		//given
		List<Users> emptyUserInList = new ArrayList<Users>();
		//when
		UsersDAO usersDAO = mock(UsersDAO.class);
		when(usersDAO.getAllUsers()).thenReturn(emptyUserInList);
		List<Users> result = new ArrayList<Users>();
		result = usersDAO.getAllUsers();
		//then
		log.info("[ result.isEmpty() = {} ], [ result.size() = {} ]", result.isEmpty(), result.size());
		assertThat(result.isEmpty())
			.isEqualTo(true);
		log.info("== End ==");
		log.info("===============================================================");
	}
	
	//==========================================================
	@Test
	public void checkUserLoginFoundTest() throws Exception {
		log.info("===============================================================");
		log.info("== checkUserLogin() : checkUserLoginFoundTest() Begin ==");
		//given
		Users user = new Users();
		user.setuId("U01");
		user.setuUsername("USERNAME01");
		user.setuPassword("123");
		//when
		UsersDAO usersDAO = mock(UsersDAO.class);
		when(usersDAO.checkUserLogin(user)).thenReturn(user.getuId());
		String userId = null;
		userId = usersDAO.checkUserLogin(user);
		//then
		log.info("[ userId = {} ]", userId);
		assertThat(userId)
			.isEqualTo("U01");
		log.info("== End ==");
		log.info("===============================================================");
	}
	
	@Test
	public void checkUserLoginNotFoundTest() throws Exception {
		log.info("===============================================================");
		log.info("== checkUserLogin() : checkUserLoginNotFoundTest() Begin ==");
		//given
		Users user = new Users();
		user.setuId("U02");
		user.setuUsername("USERNAME02");
		user.setuPassword("123");
		//when
		UsersDAO usersDAO = mock(UsersDAO.class);
		when(usersDAO.checkUserLogin(user)).thenReturn(null);
		String userId = null;
		userId = usersDAO.checkUserLogin(user);
		//then
		log.info("[ userId = {} ]", userId);
		assertThat(userId)
			.isEqualTo(null);
		log.info("== End ==");
		log.info("===============================================================");
	}
	
	//==========================================================
	@Test
	public void getUserByTokenFound() throws Exception {
		log.info("===============================================================");
		log.info("== getUserByToken() : getUserByTokenFound() Begin ==");
		// given
		String token = "7a4b758e-cc2e-4ff4-9e52-7ba07520c168";
		Users user = new Users();
		user.setuId("U01");
		user.setuUsername("USERNAME01");
		user.setuPassword("123");
		// when
		UsersDAO usersDAO = mock(UsersDAO.class);
		when(usersDAO.getUserByToken(token)).thenReturn(user);
		Users result = new Users();
		result = usersDAO.getUserByToken(token);
		// then
		log.info("[ result.toString = {} ]", result.toString());
		assertThat(user.getuId())
			.isEqualTo("U01");
		log.info("== End ==");
		log.info("===============================================================");
	}
	
	@Test
	public void getUserByTokenNotFound() throws Exception {
		log.info("===============================================================");
		log.info("== getUserByToken() : getUserByTokenNotFound() Begin ==");
		// given
		String token = "7a4b758e-cc2e-4ff4-9e52-7ba07520c168";
		Users user = new Users();
		// when
		UsersDAO usersDAO = mock(UsersDAO.class);
		when(usersDAO.getUserByToken(token)).thenReturn(user);
		Users result = new Users();
		result = usersDAO.getUserByToken(token);
		// then
		log.info("[ result.toString = {} ]", result.toString());
		assertThat(user.getuId())
			.isEqualTo(null);
		log.info("== End ==");
		log.info("===============================================================");
	}
}
