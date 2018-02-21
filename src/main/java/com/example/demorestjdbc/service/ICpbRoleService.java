package com.example.demorestjdbc.service;

import java.util.List;

import com.example.demorestjdbc.entity.CpbRole;
import com.example.demorestjdbc.entity.CpbRoleJoinCpbRoleType;

public interface ICpbRoleService {

	List<CpbRole> getRoleByUserId(Long userId) throws Exception;

	List<CpbRoleJoinCpbRoleType> getAllCpbRoleJoinCpbRoleType() throws Exception;
}
