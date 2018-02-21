package com.example.demorestjdbc.repository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demorestjdbc.entity.CpbRole;
import com.example.demorestjdbc.entity.CpbRoleJoinCpbRoleType;

@Transactional
@Repository
@Component
@PropertySource("classpath:application.properties")
public class CpbRoleDAO implements ICpbRoleDAO {

	private static final Logger log = LoggerFactory.getLogger(CpbRoleDAO.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Value("${cpb.cmes.schema}")
	private String cmesSchema;
	
	@Override
	public List<CpbRole> getRoleByUserId(Long userId) throws Exception {
		List<CpbRole> listCpbRoles = new ArrayList<CpbRole>();
		String sql = " SELECT "
				+" CR.* "
				+" FROM "
				+cmesSchema+"CPB_USER_ROLE CUR "
				+" INNER JOIN "+cmesSchema+"CPB_ROLE CR ON CUR.ROLE_ID = CR.ROLE_ID "
				+" WHERE "
				+" CUR.USER_ID = ?";
		try {
			RowMapper<CpbRole> rowMapper = new BeanPropertyRowMapper<CpbRole>(CpbRole.class);
			listCpbRoles = jdbcTemplate.query(sql, rowMapper, userId);
			log.info("(SUCCESS) Method getRoleByUserId access database success.");
		} catch (Exception e) {
			log.error("(ERROR) Method getRoleByUserId RowMapper or JDBCTemplate error. : "+e);
			throw new Exception();
		}
		return listCpbRoles;
	}

	@Override
	public List<CpbRoleJoinCpbRoleType> getAllCpbRoleJoinCpbRoleType() throws Exception {
		List<CpbRoleJoinCpbRoleType> result = new ArrayList<CpbRoleJoinCpbRoleType>();
		String sql = " SELECT "
				+" CR.* "
				+" , CRT.RT_NAME, CRT.RT_REMARK, CRT.STATUS AS CRT_STATUS, CRT.RT_ORDER "
				+" FROM "
				+cmesSchema+"CPB_ROLE CR "
				+" INNER JOIN "+cmesSchema+"CPB_ROLE_TYPE CRT ON CR.RT_ID = CRT.RT_ID";
		try {
			RowMapper<CpbRoleJoinCpbRoleType> rowMapper = new BeanPropertyRowMapper<CpbRoleJoinCpbRoleType>(CpbRoleJoinCpbRoleType.class);
			result = jdbcTemplate.query(sql, rowMapper);
			log.info("(SUCCESS) Method getRoleByUserId access database success.");
		} catch (Exception e) {
			log.error("(ERROR) Method getRoleByUserId RowMapper or JDBCTemplate error. : "+e);
			throw new Exception();
		}
		return result;
	}

}
