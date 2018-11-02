package com.wm.lotto.entity;

import java.util.List;

public class RequestFormatEntity<T> {

	private String token;
	private List<T> requetData;
	
	public RequestFormatEntity(String token, List<T> requetData) {
		super();
		this.token = token;
		this.requetData = requetData;
	}

	public RequestFormatEntity() {
		super();
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @return the requetData
	 */
	public List<T> getRequetData() {
		return requetData;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @param requetData the requetData to set
	 */
	public void setRequetData(List<T> requetData) {
		this.requetData = requetData;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RequestFormatEntity [token=" + token + ", requetData=" + requetData + "]";
	}

}
