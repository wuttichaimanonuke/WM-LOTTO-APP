package com.wm.lotto.repository.round_configure;
import java.util.List;

import com.wm.lotto.entity.round_configure.RoundConfigure;

public interface IRoundConfigureDAO {

	List<RoundConfigure> getAllRoundConfigures() throws Exception;

}