package com.wm.lotto.service.round_configure;

import java.util.Map;

public interface IRoundConfigureService {

	Map<String, Object> getCurrentActiveRoundConfigure(String token);
}
