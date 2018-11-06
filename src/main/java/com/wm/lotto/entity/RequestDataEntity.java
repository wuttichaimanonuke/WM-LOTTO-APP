package com.wm.lotto.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = false) 			//Ignore unknown properties. true=ignore , false=not ignore.
@JsonInclude(JsonInclude.Include.NON_NULL)				//Properties is null, it not include to data model.
public class RequestDataEntity<T> {
	
	private String token;
	private List<T> dataValue;

	public RequestDataEntity() {
		super();
	}

	public RequestDataEntity(String token, List<T> dataValue) {
		super();
		this.token = token;
		this.dataValue = dataValue;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @return the dataValue
	 */
	public List<T> getDataValue() {
		return dataValue;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @param dataValue the dataValue to set
	 */
	public void setDataValue(List<T> dataValue) {
		this.dataValue = dataValue;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataValue == null) ? 0 : dataValue.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestDataEntity<?> other = (RequestDataEntity<?>) obj;
		if (dataValue == null) {
			if (other.dataValue != null)
				return false;
		} else if (!dataValue.equals(other.dataValue))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RequestDataEntity [token=" + token + ", dataValue=" + dataValue + "]";
	}
}
