package com.wm.lotto.repository;

import java.util.List;

import com.wm.lotto.entity.AssignRolesToUser;

public interface IAssignRolesToUserDAO {

	List<AssignRolesToUser> getAllAssignRolesToUsers() throws Exception;

}
