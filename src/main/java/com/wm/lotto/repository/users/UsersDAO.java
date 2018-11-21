package com.wm.lotto.repository.users;

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

import com.wm.lotto.entity.users.Users;
import com.wm.lotto.entity.users.UsersRowMapper;

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
			log.debug("--result.isEmpty() = {}--",result.isEmpty());
			log.error("(ERROR) Method getAllUserss RowMapper or JDBCTemplate error. : "+e);
			throw new Exception();
		}
		return result;
	}

	@Override
	public String checkUserLogin(Users user) {
		String userId = null;
		String sql = "SELECT * FROM "+ANALYZERLOTTERY+"USERS WHERE U_USERNAME = ? AND U_PASSWORD = ?";
		Users resultQuery = new Users();
		try {
			RowMapper<Users> rowMapper = new UsersRowMapper();
			resultQuery = (Users) jdbcTemplate.queryForObject(sql, rowMapper, user.getuUsername(), user.getuPassword());
			log.debug("Get UserId({}) By username({}).",resultQuery.getuId() ,user.getuUsername());
			log.info("(SUCCESS) Method checkUserLogin access database success.");
		} catch (Exception e) {
			userId = null;
			log.error("(ERROR) Method checkUserLogin RowMapper or JDBCTemplate error. : "+e);
		}
		if (resultQuery != null) {
			userId = resultQuery.getuId();
		}
		return userId;
	}

	@Override
	public Users getUserByToken(String token) {
		String sql = new String();
		sql = " SELECT";
		sql = "		u.*";
		sql = "	FROM "+ANALYZERLOTTERY+"USERS u";
		sql = " LEFT JOIN "+ANALYZERLOTTERY+"TOKENLOGIN t on u.U_ID = t.U_ID";
		sql = " WHERE t.TL_TOKEN = '?'";
		Users resultQuery = new Users();
		try {
			RowMapper<Users> rowMapper = new UsersRowMapper();
			resultQuery = (Users) jdbcTemplate.queryForObject(sql, rowMapper, token);
			log.debug("Get User({}) By Token({}).",resultQuery.toString() ,token );
			log.info("(SUCCESS) Method getUserByToken access database success.");
		} catch (Exception e) {
			log.error("(ERROR) Method getUserByToken RowMapper or JDBCTemplate error. : "+e);
		}
		return resultQuery;
	}

}
