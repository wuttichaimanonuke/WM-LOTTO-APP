package com.wm.lotto.repository;

import java.util.List;

import com.wm.lotto.entity.Users;


public interface IUsersDAO {

	List<Users> getAllUsers() throws Exception;
	String checkUserLogin(Users user) throws Exception;

}
