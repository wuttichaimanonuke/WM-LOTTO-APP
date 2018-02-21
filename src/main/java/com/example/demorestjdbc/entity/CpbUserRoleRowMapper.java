package com.example.demorestjdbc.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CpbUserRoleRowMapper implements RowMapper<CpbUserRole> {

	@Override
	public CpbUserRole mapRow(ResultSet row, int rowNum) throws SQLException {
		CpbUserRole cpbUserRole = new CpbUserRole();
		cpbUserRole.setUserId(row.getLong("USER_ID"));
		cpbUserRole.setRoleId(row.getLong("ROLE_ID"));
		cpbUserRole.setUpdateUser(row.getString("UPDATE_USER"));
		cpbUserRole.setUpdateDateTime(row.getDate("UPDATE_DATETIME"));
		return cpbUserRole;
	}

}
