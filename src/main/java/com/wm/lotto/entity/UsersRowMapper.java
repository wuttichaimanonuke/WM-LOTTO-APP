package com.wm.lotto.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UsersRowMapper implements RowMapper<Users> {

	@Override
	public Users mapRow(ResultSet row, int rowNum) throws SQLException {
		Users entity = new Users();
		entity.setuId(row.getString("U_ID"));
		entity.setuUsername(row.getString("U_USERNAME"));
		entity.setuPassword(row.getString("U_PASSWORD"));
		entity.setuDisplayName(row.getString("U_DISPLAYNAME"));
		entity.setuDiscription(row.getString("U_DESCRIPTION"));
		entity.setuActive(row.getString("U_ACTIVE"));
		entity.setModifyDate(row.getDate("MODIFYDATE"));
		entity.setModifyBy(row.getString("MODIFYBY"));
		entity.setCreateDatetime(row.getDate("CREATEDATETIME"));
		entity.setCreateBy(row.getString("CREATEBY"));
		return entity;
	}

}
