package com.example.demorestjdbc.repository;

import java.util.List;

import com.example.demorestjdbc.entity.CpbRole;
import com.example.demorestjdbc.entity.CpbRoleJoinCpbRoleType;

public interface ICpbRoleDAO {

	List<CpbRole> getRoleByUserId(Long userId) throws Exception;

	List<CpbRoleJoinCpbRoleType> getAllCpbRoleJoinCpbRoleType() throws Exception;
}
