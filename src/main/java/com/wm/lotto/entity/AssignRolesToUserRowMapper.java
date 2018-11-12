package com.wm.lotto.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AssignRolesToUserRowMapper implements RowMapper<AssignRolesToUser> {

	@Override
	public AssignRolesToUser mapRow(ResultSet row, int rowNum) throws SQLException {
		AssignRolesToUser entity = new AssignRolesToUser();
		entity.setAruId(row.getInt("ARU_ID"));
		entity.setRId(row.getInt("R_ID"));
		entity.setUId(row.getString("U_ID"));
		entity.setAruActive(row.getString("ARU_ACTIVE"));
		entity.setModifyDate(row.getDate("MODIFYDATE"));
		entity.setModifyBy(row.getString("MODIFYBY"));
		entity.setCreateDatetime(row.getDate("CREATEDATETIME"));
		entity.setCreateBy(row.getString("CREATEBY"));
		return entity;
	}

}
