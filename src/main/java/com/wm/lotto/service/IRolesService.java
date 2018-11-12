package com.wm.lotto.service;

import java.util.List;

import com.wm.lotto.entity.Roles;
import com.wm.lotto.entity.Users;

public interface IRolesService {

	List<Roles> getAllRolesIsActiveByUid(Users user);

}
