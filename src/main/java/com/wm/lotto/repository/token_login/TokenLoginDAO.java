package com.wm.lotto.repository.token_login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wm.lotto.entity.token_login.TokenLogin;
import com.wm.lotto.entity.token_login.TokenLoginRowMapper;

@Transactional
@Repository
@Component
@PropertySource("classpath:application.properties")
public class TokenLoginDAO implements ITokenLoginDAO {

	private static final Logger log = LoggerFactory.getLogger(TokenLoginDAO.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${database.schema}")
	private String ANALYZERLOTTERY;
	
	@Value("${token.config.expire-date}")
	private String expireDate;

	@Override
	public List<TokenLogin> getAllTokenLogins() {
		String sql = "SELECT * FROM "+ANALYZERLOTTERY+"TOKENLOGIN";
		RowMapper<TokenLogin> rowMapper = new TokenLoginRowMapper();
		List<TokenLogin> result = new ArrayList<TokenLogin>();
		try {
			result = jdbcTemplate.query(sql, rowMapper);
			log.info("(SUCCESS) Method getAllTokenLogins access database success.");
		} catch (Exception e) {
			log.error("(ERROR) Method getAllTokenLogins RowMapper or JDBCTemplate error. : "+e);
		}
		return result;
	}

	@Override
	public TokenLogin getTokenLoginByUserId(String userId) {
		String sql = "SELECT * FROM "+ANALYZERLOTTERY+"TOKENLOGIN WHERE U_ID = ?";
		TokenLogin resultQuery = new  TokenLogin();
		try {
			RowMapper<TokenLogin> rowMapper = new TokenLoginRowMapper();
			resultQuery = jdbcTemplate.queryForObject(sql, rowMapper, userId);
			log.info("(SUCCESS) Method checkHasTokenByUserId access database success.");
		} catch (Exception e) {
			log.error("(ERROR) Method checkHasTokenByUserId RowMapper or JDBCTemplate error. : "+e);
		}
		return resultQuery;
	}

	@Override
	public void delectTokenLoginByUserId(String userId) {
		String sql = "DELETE "+ANALYZERLOTTERY+"TOKENLOGIN WHERE U_ID = ?";
		try {
			jdbcTemplate.update(sql, userId);
			log.info("(SUCCESS) Delete token user ("+userId+") success.");
		} catch (Exception e) {
			log.info("(ERROR) Delete token user ("+userId+") fail. : "+e.getMessage());
		}
	}

	@Override
	public void insertTokenLogin(TokenLogin tokenLogin) {
		String sql = "INSERT INTO "+ANALYZERLOTTERY+"TOKENLOGIN (TL_TOKEN, U_ID, EXPIRY_DATE) VALUES (?, ?, SYSDATE + "+expireDate+"/24)";
		try {
			jdbcTemplate.update(sql, tokenLogin.getTlToken(), tokenLogin.getUId());
			log.info("(SUCCESS) INSERT token of user ("+tokenLogin.getUId()+") success.");
		} catch (Exception e) {
			log.info("(ERROR) INSERT token of user ("+tokenLogin.getUId()+") fail. : "+e.getMessage());
		}
	}

	@Override
	public TokenLogin getTokenLoginByToken(String token) {
		String sql = "SELECT * FROM "+ANALYZERLOTTERY+"TOKENLOGIN WHERE TL_TOKEN = ?";
		TokenLogin resultQuery = new TokenLogin();
		try {
			RowMapper<TokenLogin> rowMapper = new TokenLoginRowMapper();
			resultQuery = jdbcTemplate.queryForObject(sql, rowMapper, token);
			log.debug("Token({}) has keep in system.",token);
			log.info("(SUCCESS) Method getTokenLoginByToken access database success.");
		} catch (Exception e) {
			log.error("(ERROR) Method getTokenLoginByToken RowMapper or JDBCTemplate error. : "+e);
		}
		return resultQuery;
	}

	@Override
	public boolean checkExistThisTokenAndUid(String token, String uId) {
		String sql = "SELECT * FROM "+ANALYZERLOTTERY+"TOKENLOGIN WHERE TL_TOKEN = ? AND U_ID = ? AND EXPIRY_DATE >= SYSDATE";
		if ( !(token == null) && !(token.trim().equals("")) && !(uId == null) && !(uId.trim().equals("")) ) {
			TokenLogin resultQuery = new TokenLogin();
			try {
				log.info("Method checkExistThisTokenAndUid check parametor token({}) and uId({}).", token, uId);
				RowMapper<TokenLogin> rowMapper = new TokenLoginRowMapper();
				resultQuery = jdbcTemplate.queryForObject(sql, rowMapper, token, uId);
				log.info("(SUCCESS) Method checkExistThisTokenAndUid access database success.");
				if ( !(resultQuery.getTlToken() == null) ) {
					log.info("Token({}) and Uid({}) has keep in system.", token, uId);
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				log.info("(ERROR) Method checkExistThisTokenAndUid RowMapper or JDBCTemplate error. : "+e);
			}
		}
		return false;
	}

	@Override
	public String loginWithFunc(String username, String password, String uuidToken) {
		String result = null;
		if (	!(username.trim().isEmpty())	&& 	!(username.equals(null))	&&
				!(password.trim().isEmpty())	&&	!(password.equals(null))	&&
				!(uuidToken.trim().isEmpty())	&&	!(uuidToken.equals(null))
		) {
			try {
				SimpleJdbcCall jdbcCall  = new SimpleJdbcCall(jdbcTemplate)
						.withFunctionName("FUNC_LOGIN");
				SqlParameterSource parameter_in = new MapSqlParameterSource()
														.addValue("username_in", username)
														.addValue("password_in", password)
														.addValue("token_in", uuidToken)
														.addValue("expiry_date_config", expireDate);
				Map<String, Object> resultFromFunc = jdbcCall.execute(parameter_in);
				result = resultFromFunc.get("return").toString();
				if ( (result.equals("NULL")) || (result.trim().isEmpty()) || (result.equals(null)) ) {
					result = "EXCEPTION OTHER";
				}
			} catch (Exception e) {
				result = "EXCEPTION OTHER";
			}
		} else {
			result = "INPUT INVALID";
		}
		return result;
	}

	@Override
	public String logoutWithProc(String uuidToken) {
		String result = "NOT FOUND";
		log.info("DAO token = {}",uuidToken);
		if (	!(uuidToken.trim().isEmpty()) && !(uuidToken.equals(null)) ) {
			try {
				SimpleJdbcCall jdbcCall  = new SimpleJdbcCall(jdbcTemplate)
						.withProcedureName("PROC_LOGOUT");
				SqlParameterSource parameter_in = new MapSqlParameterSource()
														.addValue("token_in", uuidToken);
				Map<String, Object> resultFromProc = jdbcCall.execute(parameter_in);
				result = (String) resultFromProc.get("RESULT_OUT");
				log.info("result = {}",result);
			} catch (Exception e) {
				log.info("Error : "+e);
				result = "NOT FOUND";
			}
		} else {
			result = "NOT FOUND";
		}
		return result;
	}

}
