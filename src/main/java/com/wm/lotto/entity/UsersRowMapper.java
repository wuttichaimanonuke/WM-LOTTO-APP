package com.wm.lotto.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UsersRowMapper implements RowMapper<Users> {

	@Override
	public Users mapRow(ResultSet row, int rowNum) throws SQLException {
		Users entity = new Users();
		entity.setUId(row.getString("U_ID"));
		entity.setUUsername(row.getString("U_USERNAME"));
		entity.setUPassword(row.getString("U_PASSWORD"));
		entity.setUDisplayName(row.getString("U_DISPLAYNAME"));
		entity.setUDiscription(row.getString("U_DESCRIPTION"));
		entity.setUActive(row.getString("U_ACTIVE"));
		entity.setModifyDate(row.getDate("MODIFYDATE"));
		entity.setModifyBy(row.getString("MODIFYBY"));
		entity.setCreateDatetime(row.getDate("CREATEDATETIME"));
		entity.setCreateBy(row.getString("CREATEBY"));
		return entity;
	}

}
