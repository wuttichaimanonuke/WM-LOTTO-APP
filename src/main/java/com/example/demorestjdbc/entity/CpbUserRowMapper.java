package com.example.demorestjdbc.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CpbUserRowMapper implements RowMapper<CpbUser> {

	@Override
	public CpbUser mapRow(ResultSet row, int rowNum) throws SQLException {
		CpbUser cpbUser = new CpbUser();
		cpbUser.setUserId(row.getLong("USER_ID"));
		cpbUser.setUserLogin(row.getString("USER_LOGIN"));
		cpbUser.setUserPass(row.getString("USER_PASS"));
		cpbUser.setTitle(row.getString("TITLE"));
		cpbUser.setFullName(row.getString("FULL_NAME"));
		cpbUser.seteMail(row.getString("E_MAIL"));
		cpbUser.setStatus(row.getInt("STATUS"));
		cpbUser.setUpdateUser(row.getString("UPDATE_USER"));
		cpbUser.setUpdateDateTime(row.getDate("UPDATE_DATETIME"));
		return cpbUser;
	}

}
