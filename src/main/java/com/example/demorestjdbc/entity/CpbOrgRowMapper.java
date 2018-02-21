package com.example.demorestjdbc.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CpbOrgRowMapper implements RowMapper<CpbOrg> {

	@Override
	public CpbOrg mapRow(ResultSet row, int rowNum) throws SQLException {
		CpbOrg cpbOrg = new CpbOrg();
		cpbOrg.setOrgId(row.getLong("ORG_ID"));
		cpbOrg.setOrgCode(row.getString("ORG_CODE"));
		cpbOrg.setOrgName(row.getString("ORG_NAME"));
		cpbOrg.setOrgSname(row.getString("ORG_SNAME"));
		cpbOrg.setOrgIdRef(row.getLong("ORG_ID_REF"));
		cpbOrg.setOrgType(row.getInt("ORG_TYPE"));
		cpbOrg.setStatus(row.getInt("STATUS"));
		cpbOrg.setUpdateUser(row.getString("UPDATE_USER"));
		cpbOrg.setUpdateDateTime(row.getDate("UPDATE_DATETIME"));
		cpbOrg.setDctmGroupRebuildStatus(row.getInt("DCTM_GROUP_REBUILD_STATUS"));
		cpbOrg.setDctmGroupRebuildDateTime(row.getDate("DCTM_GROUP_REBUILD_DATETIME"));
		return cpbOrg;
	}

}
