package com.example.demorestjdbc.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CpbRoleRowMapper implements RowMapper<CpbRole> {

	@Override
	public CpbRole mapRow(ResultSet row, int rowNum) throws SQLException {
		CpbRole cpbRole = new CpbRole();
		cpbRole.setRoleId(row.getLong("ROLE_ID"));
		cpbRole.setOrgId(row.getLong("ORG_ID"));
		cpbRole.setRtId(row.getInt("RT_ID"));
		cpbRole.setRoleName(row.getString("ROLE_NAME"));
		cpbRole.setStatus(row.getInt("STATUS"));
		cpbRole.setUpdateUser(row.getString("UPDATE_USER"));
		cpbRole.setUpdateDateTime(row.getDate("UPDATE_DATETIME"));
		return cpbRole;
	}

}
