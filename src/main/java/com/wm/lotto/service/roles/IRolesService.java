package com.wm.lotto.service.roles;

import java.util.List;

import com.wm.lotto.entity.roles.Roles;
import com.wm.lotto.entity.users.Users;

public interface IRolesService {

	List<Roles> getAllRolesIsActiveByUid(Users user);

}
