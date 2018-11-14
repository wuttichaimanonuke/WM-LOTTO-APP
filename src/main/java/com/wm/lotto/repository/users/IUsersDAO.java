package com.wm.lotto.repository.users;

import java.util.List;

import com.wm.lotto.entity.users.Users;


public interface IUsersDAO {

	List<Users> getAllUsers() throws Exception;
	String checkUserLogin(Users user) throws Exception;

}
