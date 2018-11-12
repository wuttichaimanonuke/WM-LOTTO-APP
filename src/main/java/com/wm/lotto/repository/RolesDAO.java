package com.wm.lotto.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.conn.EofSensorWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wm.lotto.entity.Roles;
import com.wm.lotto.entity.RolesRowMapper;

@Transactional
@Repository
@Component
@PropertySource("classpath:application.properties")
public class RolesDAO implements IRolesDAO {

	private static final Logger log = LoggerFactory.getLogger(RolesDAO.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${database.schema}")
	private String ANALYZERLOTTERY;

	@Override
	public List<Roles> getAllRoles() throws Exception {
		String sql = "SELECT * FROM "+ANALYZERLOTTERY+"ROLES";
		RowMapper<Roles> rowMapper = new RolesRowMapper();
		List<Roles> result = new ArrayList<Roles>();
		try {
			result = jdbcTemplate.query(sql, rowMapper);
			log.info("(SUCCESS) Method getAllRoless access database success.");
		} catch (Exception e) {
			log.error("(ERROR) Method getAllRoless RowMapper or JDBCTemplate error. : "+e);
			throw new Exception();
		}
		return result;
	}

	@Override
	public List<Roles> getAllRolesActiveByUid(String uId) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT");
		sql.append(" r.*");
		sql.append(" FROM ROLES r");
		sql.append(" LEFT JOIN ASSIGNROLESTOUSER a ON  r.R_ID = a.R_ID");
		sql.append(" WHERE a.U_ID = ? AND a.ARU_ACTIVE = 'ACTIVE'");
		RowMapper<Roles> rowMapper = new RolesRowMapper();
		List<Roles> result = new ArrayList<Roles>();
		try {
			result = jdbcTemplate.query(sql.toString(), rowMapper);
			log.info("(SUCCESS) Get all roles is active of user("+uId+") from database success.");
		} catch (Exception e) {
			log.error("(ERROR) Can't get role ia active of user("+uId+") from database. RowMapper or JDBCTemplate error. : "+e);
		}
		return result;
	}

}
