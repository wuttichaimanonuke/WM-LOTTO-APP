package com.wm.lotto.repository.assign_roles_to_user;

import java.util.List;

import com.wm.lotto.entity.assign_roles_to_user.AssignRolesToUser;

public interface IAssignRolesToUserDAO {

	List<AssignRolesToUser> getAllAssignRolesToUsers() throws Exception;

}
