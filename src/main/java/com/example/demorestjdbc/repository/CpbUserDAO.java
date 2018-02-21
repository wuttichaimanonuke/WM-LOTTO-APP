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

import com.example.demorestjdbc.entity.CpbUser;
import com.example.demorestjdbc.entity.CpbUserRowMapper;

@Transactional
@Repository
@Component
@PropertySource("classpath:application.properties")
public class CpbUserDAO implements ICpbUserDAO {

	private static final Logger log = LoggerFactory.getLogger(CpbUserDAO.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Value("${cpb.cmes.schema}")
	private String cmesSchema;
	
	@Override
	public List<CpbUser> getAllCpbUsers() throws Exception {
		String sql = "SELECT * FROM "+cmesSchema+"CPB_USER";
		RowMapper<CpbUser> rowMapper = new CpbUserRowMapper();
		List<CpbUser> result = new ArrayList<CpbUser>();
		try {
			result = jdbcTemplate.query(sql, rowMapper);
			log.info("(SUCCESS) Method getAllCpbUsers access database success.");
		} catch (Exception e) {
			log.error("(ERROR) Method getAllCpbUsers RowMapper or JDBCTemplate error. : "+e);
			throw new Exception();
		}
		return result;
	}

	@Override
	public CpbUser getCpbUserByUserId(long userId) throws Exception {
		String sql = " SELECT "
					+" * "
					+" FROM "
					+cmesSchema+"CPB_USER"
					+" WHERE "
					+" USER_ID = ?";
		CpbUser cpbUser = new CpbUser();
		try {
			RowMapper<CpbUser> rowMapper = new BeanPropertyRowMapper<CpbUser>(CpbUser.class);
			cpbUser = jdbcTemplate.queryForObject(sql, rowMapper, userId);
			log.info("(SUCCESS) Method getCpbUserByUserId access database success.");
		} catch (Exception e) {
			log.error("(ERROR) Method getCpbUserByUserId RowMapper or JDBCTemplate error. : "+e);
			throw new Exception();
		}
		return cpbUser;
	}
	
	@Override
	public Boolean userIdExists(long userId) throws Exception {
		String sql = "SELECT COUNT(*) FROM "+cmesSchema+"CPB_USER WHERE USER_ID = ?";
		int count;
		Boolean result;
		try {
			count = jdbcTemplate.queryForObject(sql, Integer.class, userId);
			log.info("(SUCCESS) Method userIdExists access database success.");
			if (count == 0) {
				result = false;
			} else {
				result = true;
			}
		} catch (Exception e) {
			log.error("(ERROR) Method userIdExists RowMapper or JDBCTemplate error. : "+e);
			throw new Exception();
		}
		return result;
	}

	@Override
	public Boolean userLoginExists(String userLogin) throws Exception {
		String sql = "SELECT COUNT(*) FROM "+cmesSchema+"CPB_USER WHERE USER_LOGIN = ?";
		int count;
		Boolean result;
		try {
			count = jdbcTemplate.queryForObject(sql, Integer.class, userLogin);
			log.info("(SUCCESS) Method userLoginExists access database success.");
			if (count == 0) {
				result = false;
			} else {
				result = true;
			}
		} catch (Exception e) {
			log.error("(ERROR) Method userLoginExists RowMapper or JDBCTemplate error. : "+e);
			throw new Exception();
		}
		return result;
	}

	@Override
	public Boolean fullNameExists(String fullName) throws Exception {
		String sql = "SELECT COUNT(*) FROM "+cmesSchema+"CPB_USER WHERE FULL_NAME = ?";
		int count;
		Boolean result;
		try {
			count = jdbcTemplate.queryForObject(sql, Integer.class, fullName);
			log.info("(SUCCESS) Method fullNameExists access database success.");
			if (count == 0) {
				result = false;
			} else {
				result = true;
			}
		} catch (Exception e) {
			log.error("(ERROR) Method fullNameExists RowMapper or JDBCTemplate error. : "+e);
			throw new Exception();
		}
		return result;
	}

	@Override
	public Boolean eMailExists(String eMail) throws Exception {
		String sql = "SELECT COUNT(*) FROM "+cmesSchema+"CPB_USER WHERE E_MAIL = ?";
		int count;
		Boolean result;
		try {
			count = jdbcTemplate.queryForObject(sql, Integer.class, eMail);
			log.info("(SUCCESS) Method eMailExists access database success.");
			if (count == 0) {
				result = false;
			} else {
				result = true;
			}
		} catch (Exception e) {
			log.error("(ERROR) Method eMailExists RowMapper or JDBCTemplate error. : "+e);
			throw new Exception();
		}
		return result;
	}

}
