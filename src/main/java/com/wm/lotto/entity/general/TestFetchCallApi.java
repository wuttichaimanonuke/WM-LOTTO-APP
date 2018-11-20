package com.wm.lotto.entity.general;

public class TestFetchCallApi {
	
	private String token;

	public TestFetchCallApi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestFetchCallApi(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "TestFetchCallApi [token=" + token + "]";
	}
	
}
