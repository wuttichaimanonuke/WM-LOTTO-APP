package com.wm.lotto.repository.roles;

import java.util.List;

import com.wm.lotto.entity.roles.Roles;

public interface IRolesDAO {

	List<Roles> getAllRoles() throws Exception;

	List<Roles> getAllRolesIsActiveByUid(String uId);
}