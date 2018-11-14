package com.wm.lotto.repository.assign_roles_to_user;

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

import com.wm.lotto.entity.assign_roles_to_user.AssignRolesToUser;
import com.wm.lotto.entity.assign_roles_to_user.AssignRolesToUserRowMapper;

@Transactional
@Repository
@Component
@PropertySource("classpath:application.properties")
public class AssignRolesToUserDAO implements IAssignRolesToUserDAO {

	private static final Logger log = LoggerFactory.getLogger(AssignRolesToUserDAO.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${database.schema}")
	private String ANALYZERLOTTERY;

	@Override
	public List<AssignRolesToUser> getAllAssignRolesToUsers() throws Exception {
		String sql = "SELECT * FROM "+ANALYZERLOTTERY+"ASSIGNROLESTOUSER";
		RowMapper<AssignRolesToUser> rowMapper = new AssignRolesToUserRowMapper();
		List<AssignRolesToUser> result = new ArrayList<AssignRolesToUser>();
		try {
			result = jdbcTemplate.query(sql, rowMapper);
			log.info("(SUCCESS) Method getAllAssignRolesToUsers access database success.");
		} catch (Exception e) {
			log.error("(ERROR) Method getAllAssignRolesToUsers RowMapper or JDBCTemplate error. : "+e);
			throw new Exception();
		}
		return result;
	}

}
