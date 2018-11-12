package com.wm.lotto.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RolesRowMapper implements RowMapper<Roles> {

	@Override
	public Roles mapRow(ResultSet row, int rowNum) throws SQLException {
		Roles entity = new Roles();
		entity.setRId(row.getInt("R_ID"));
		entity.setRName(row.getString("R_NAME"));
		entity.setRDescription(row.getString("R_DESCRIPTION"));
		entity.setRActive(row.getString("R_ACTIVE"));
		entity.setModifyDate(row.getDate("MODIFYDATE"));
		entity.setModifyBy(row.getString("MODIFYBY"));
		entity.setCreateDatetime(row.getDate("CREATEDATETIME"));
		entity.setCreateBy(row.getString("CREATEBY"));
		return entity;
	}

}
