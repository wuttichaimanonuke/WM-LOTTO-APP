package com.example.demorestjdbc.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CpbRoleJoinCpbRoleTypeRowMapper implements RowMapper<CpbRoleJoinCpbRoleType> {

	@Override
	public CpbRoleJoinCpbRoleType mapRow(ResultSet row, int rowNum) throws SQLException {
		CpbRoleJoinCpbRoleType cpbRoleJoinCpbRoleType = new CpbRoleJoinCpbRoleType();
		cpbRoleJoinCpbRoleType.setRoleId(row.getLong("ROLE_ID"));
		cpbRoleJoinCpbRoleType.setOrgId(row.getLong("ORG_ID"));
		cpbRoleJoinCpbRoleType.setRtId(row.getInt("RT_ID"));
		cpbRoleJoinCpbRoleType.setRoleName(row.getString("ROLE_NAME"));
		cpbRoleJoinCpbRoleType.setStatus(row.getInt("STATUS"));
		cpbRoleJoinCpbRoleType.setUpdateUser(row.getString("UPDATE_USER"));
		cpbRoleJoinCpbRoleType.setUpdateDateTime(row.getDate("UPDATE_DATETIME"));
		cpbRoleJoinCpbRoleType.setRtName(row.getString("RT_NAME"));
		cpbRoleJoinCpbRoleType.setRtRemark(row.getString("RT_REMARK"));
		cpbRoleJoinCpbRoleType.setCrtStatus(row.getInt("CRT_STATUS"));
		cpbRoleJoinCpbRoleType.setRtOrder(row.getInt("RT_ORDER"));
		return cpbRoleJoinCpbRoleType;
	}

}
