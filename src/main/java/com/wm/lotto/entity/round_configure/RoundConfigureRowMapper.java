package com.wm.lotto.entity.round_configure;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RoundConfigureRowMapper implements RowMapper<RoundConfigure> {

	@Override
	public RoundConfigure mapRow(ResultSet row, int rowNum) throws SQLException {
		RoundConfigure entity = new RoundConfigure();
		entity.setRcfId(row.getString("RCF_ID"));
		entity.setrYear(row.getInt("R_YEAR"));
		entity.setrMonth(row.getInt("R_MONTH"));
		entity.setrRound(row.getInt("R_ROUND"));
		entity.setrStatus(row.getString("R_STATUS"));
		entity.setModifyDate(row.getDate("MODIFYDATE"));
		entity.setModifyBy(row.getString("MODIFYBY"));
		entity.setCreateDatetime(row.getDate("CREATEDATETIME"));
		entity.setCreateBy(row.getString("CREATEBY"));
		return entity;
	}

}
