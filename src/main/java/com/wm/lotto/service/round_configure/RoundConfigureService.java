package com.wm.lotto.service.round_configure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wm.lotto.entity.round_configure.RoundConfigure;
import com.wm.lotto.general.ConstantsResult;
import com.wm.lotto.general.ConstantsResultDAO;
import com.wm.lotto.repository.round_configure.IRoundConfigureDAO;
import com.wm.lotto.service.token.ITokenService;

@Service
public class RoundConfigureService implements IRoundConfigureService {
	
	private static final Logger log = LoggerFactory.getLogger(RoundConfigureService.class);
	
	@Autowired
	private ITokenService tokenService;
	
	@Autowired
	private IRoundConfigureDAO roundConfigureDAO;

	@Override
	public Map<String, Object> getCurrentActiveRoundConfigure(String token) {
		Map<String, Object> result = new HashMap<String, Object>();
		String result_service = null;
		List<RoundConfigure> listRoundConfigure = new ArrayList<RoundConfigure>();
		if ( !(token.equals(null)) && !(token.trim().equals("")) ) {
			try {
				result_service = tokenService.checkTokenIsExpire(token);
				switch (result_service) {
				case ConstantsResultDAO.result_checkTokenIsExpir_Ok:
					log.info("Method getCurrentActiveRoundConfigure check token is ok.");
					try {
						listRoundConfigure = roundConfigureDAO.getCurrentActiveRoundConfigure();
						if (listRoundConfigure.size() == 1) {
							result.put("resultCode", ConstantsResult.GET_CURRENT_ACTIVE_ROUNDCONFIG_OK_CODE);
							result.put("resultMessage", ConstantsResult.GET_CURRENT_ACTIVE_ROUNDCONFIG_OK__MSG);
							result.put("result", listRoundConfigure.get(0));
						} else if (listRoundConfigure.size() == 0) {
							result.put("resultCode", ConstantsResult.GET_CURRENT_ACTIVE_ROUNDCONFIG_FAIL_CODE);
							result.put("resultMessage", ConstantsResult.GET_CURRENT_ACTIVE_ROUNDCONFIG_FAIL_MSG);
						} else {
							result.put("resultCode", ConstantsResult.GET_CURRENT_ACTIVE_ROUNDCONFIG_DATAERROR_CODE);
							result.put("resultMessage", ConstantsResult.GET_CURRENT_ACTIVE_ROUNDCONFIG_DATAERROR_MSG);
						}
					} catch (Exception e) {
						result.put("resultCode", ConstantsResult.GET_CURRENT_ACTIVE_ROUNDCONFIG_DATAERROR_CODE);
						result.put("resultMessage", ConstantsResult.GET_CURRENT_ACTIVE_ROUNDCONFIG_DATAERROR_MSG);
					}
					break;
				case ConstantsResultDAO.result_checkTokenIsExpir_Fail:
					log.info("Method getCurrentActiveRoundConfigure check token is fail.");
					result.put("resultCode", ConstantsResult.CHECK_TOKEN_IS_EXPIRE_FAIL_CODE);
					result.put("resultMessage", ConstantsResult.CHECK_TOKEN_IS_EXPIRE_FAIL_MSG);
					break;
				default:
					log.info("Method getCurrentActiveRoundConfigure check token is other fail.");
					result.put("resultCode", ConstantsResult.CHECK_TOKEN_IS_EXPIRE_FAIL_CODE);
					result.put("resultMessage", ConstantsResult.CHECK_TOKEN_IS_EXPIRE_FAIL_MSG);
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Method getCurrentActiveRoundConfigure check token is exception error. : "+e);
				result.put("resultCode", ConstantsResult.CHECK_TOKEN_IS_EXPIRE_FAIL_CODE);
				result.put("resultMessage", ConstantsResult.CHECK_TOKEN_IS_EXPIRE_FAIL_MSG);
			}
		} else {
			log.info("Method getCurrentActiveRoundConfigure token is error.");
			result.put("resultCode", ConstantsResult.CHECK_TOKEN_IS_EXPIRE_FAIL_CODE);
			result.put("resultMessage", ConstantsResult.CHECK_TOKEN_IS_EXPIRE_FAIL_MSG);
		}
		return result;
	}

}
