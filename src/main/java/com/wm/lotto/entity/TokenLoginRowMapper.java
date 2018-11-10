package com.wm.lotto.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TokenLoginRowMapper implements RowMapper<TokenLogin> {

	@Override
	public TokenLogin mapRow(ResultSet row, int rowNum) throws SQLException {
		TokenLogin entity = new TokenLogin();
		entity.setTlToken(row.getString("TL_TOKEN"));
		entity.setUId(row.getString("U_ID"));
		entity.setExpireDate(row.getDate("EXPIRY_DATE"));
		entity.setModifyDate(row.getDate("MODIFYDATE"));
		entity.setModifyBy(row.getString("MODIFYBY"));
		entity.setCreateDatetime(row.getDate("CREATEDATETIME"));
		entity.setCreateBy(row.getString("CREATEBY"));
		return entity;
	}

}
