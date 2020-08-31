package com.wm.lotto.repository.round_configure;

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

import com.wm.lotto.entity.round_configure.RoundConfigure;
import com.wm.lotto.entity.round_configure.RoundConfigureRowMapper;
import com.wm.lotto.entity.token_login.TokenLogin;
import com.wm.lotto.entity.token_login.TokenLoginRowMapper;

@Transactional
@Repository
@Component
@PropertySource("classpath:application.properties")
public class RoundConfigureDAO implements IRoundConfigureDAO {

	private static final Logger log = LoggerFactory.getLogger(RoundConfigureDAO.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${database.schema}")
	private String ANALYZERLOTTERY;

	@Override
	public List<RoundConfigure> getAllRoundConfigures() throws Exception {
		String sql = "SELECT * FROM "+ANALYZERLOTTERY+"ROUND_CONFIGURE";
		RowMapper<RoundConfigure> rowMapper = new RoundConfigureRowMapper();
		List<RoundConfigure> result = new ArrayList<RoundConfigure>();
		try {
			result = jdbcTemplate.query(sql, rowMapper);
			log.info("(SUCCESS) Method getAllRoundConfigures access database success.");
		} catch (Exception e) {
			log.error("(ERROR) Method getAllRoundConfigures RowMapper or JDBCTemplate error. : "+e);
			throw new Exception();
		}
		return result;
	}

	@Override
	public List<RoundConfigure> getCurrentActiveRoundConfigure() {
		List<RoundConfigure> result = new ArrayList<RoundConfigure>();
		String sql = "SELECT * FROM "+ANALYZERLOTTERY+"ROUND_CONFIGURE WHERE R_STATUS = 'ACTIVE'";
		RowMapper<RoundConfigure> rowMapper = new RoundConfigureRowMapper();
		try {
			result = jdbcTemplate.query(sql, rowMapper);
			log.info("(SUCCESS) Method getCurrentActiveRoundConfigure success.");
		} catch (Exception e) {
			log.info("(ERROR) Method getCurrentActiveRoundConfigure RowMapper or JDBCTemplate error. : "+e);
		}
		return result;
	}

}
