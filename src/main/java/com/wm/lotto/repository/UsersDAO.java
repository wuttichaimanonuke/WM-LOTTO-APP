package com.wm.lotto.repository;

import java.util.ArrayList;
import java.util.List;

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

import com.wm.lotto.entity.Users;
import com.wm.lotto.entity.UsersRowMapper;

@Transactional
@Repository
@Component
@PropertySource("classpath:application.properties")
public class UsersDAO implements IUsersDAO {

	private static final Logger log = LoggerFactory.getLogger(UsersDAO.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${database.schema}")
	private String ANALYZERLOTTERY;

	@Override
	public List<Users> getAllUsers() throws Exception {
		String sql = "SELECT * FROM "+ANALYZERLOTTERY+"USERS";
		RowMapper<Users> rowMapper = new UsersRowMapper();
		List<Users> result = new ArrayList<Users>();
		try {
			result = jdbcTemplate.query(sql, rowMapper);
			log.info("(SUCCESS) Method getAllUserss access database success.");
		} catch (Exception e) {
			log.error("(ERROR) Method getAllUserss RowMapper or JDBCTemplate error. : "+e);
			throw new Exception();
		}
		return result;
	}

	@Override
	public String checkUserLogin(Users user) throws Exception {
		String userId = null;
		String sql = "SELECT * FROM "+ANALYZERLOTTERY+"USERS WHERE U_USERNAME = ? AND U_PASSWORD = ?";
		Users resultQuery = new Users();
		try {
			RowMapper<Users> rowMapper = new UsersRowMapper();
			resultQuery = (Users) jdbcTemplate.queryForObject(sql, rowMapper, user.getuUsername(), user.getuPassword());
			log.info("(SUCCESS) Method checkUserLogin access database success.");
		} catch (Exception e) {
			log.error("(ERROR) Method checkUserLogin RowMapper or JDBCTemplate error. : "+e);
			throw new Exception();
		}
		if (resultQuery != null) {
			userId = resultQuery.getuId();
		}
		return userId;
	}

}
