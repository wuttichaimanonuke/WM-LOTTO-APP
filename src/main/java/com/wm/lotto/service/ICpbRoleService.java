package com.wm.lotto.service;

import java.util.List;

import com.wm.lotto.entity.CpbRole;
import com.wm.lotto.entity.CpbRoleJoinCpbRoleType;

public interface ICpbRoleService {

	List<CpbRole> getRoleByUserId(Long userId) throws Exception;

	List<CpbRoleJoinCpbRoleType> getAllCpbRoleJoinCpbRoleType() throws Exception;
}
