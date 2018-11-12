package com.wm.lotto.repository;

import java.util.List;

import com.wm.lotto.entity.Roles;

public interface IRolesDAO {

	List<Roles> getAllRoles() throws Exception;

	List<Roles> getAllRolesActiveByUid(String uId);
}