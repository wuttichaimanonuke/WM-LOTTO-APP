package com.wm.lotto.entity.token_login;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TokenLogin {

	private String tlToken;
	private String uId;
	private Date expireDate;
	private Date modifyDate;
	private String modifyBy;
	private Date createDatetime;
	private String createBy;

	@JsonIgnore

	public TokenLogin() {
		super();
	}

	public TokenLogin(String tlToken, String uId, Date expireDate, Date modifyDate, String modifyBy, Date createDatetime, String createBy) {
		super();
		this.tlToken = tlToken;
		this.uId = uId;
		this.expireDate = expireDate;
		this.modifyDate = modifyDate;
		this.modifyBy = modifyBy;
		this.createDatetime = createDatetime;
		this.createBy = createBy;
	}

	public String getTlToken() {
		return tlToken;
	}

	public String getUId() {
		return uId;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public Date getCreateDatetime() {
		return createDatetime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setTlToken(String tlToken) {
		this.tlToken = tlToken;
	}

	public void setUId(String uId) {
		this.uId = uId;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createBy == null) ? 0 : createBy.hashCode());
		result = prime * result + ((createDatetime == null) ? 0 : createDatetime.hashCode());
		result = prime * result + ((expireDate == null) ? 0 : expireDate.hashCode());
		result = prime * result + ((modifyBy == null) ? 0 : modifyBy.hashCode());
		result = prime * result + ((modifyDate == null) ? 0 : modifyDate.hashCode());
		result = prime * result + ((tlToken == null) ? 0 : tlToken.hashCode());
		result = prime * result + ((uId == null) ? 0 : uId.hashCode());
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
		TokenLogin other = (TokenLogin) obj;
		if (createBy == null) {
			if (other.createBy != null)
				return false;
		} else if (!createBy.equals(other.createBy))
			return false;
		if (createDatetime == null) {
			if (other.createDatetime != null)
				return false;
		} else if (!createDatetime.equals(other.createDatetime))
			return false;
		if (expireDate == null) {
			if (other.expireDate != null)
				return false;
		} else if (!expireDate.equals(other.expireDate))
			return false;
		if (modifyBy == null) {
			if (other.modifyBy != null)
				return false;
		} else if (!modifyBy.equals(other.modifyBy))
			return false;
		if (modifyDate == null) {
			if (other.modifyDate != null)
				return false;
		} else if (!modifyDate.equals(other.modifyDate))
			return false;
		if (tlToken == null) {
			if (other.tlToken != null)
				return false;
		} else if (!tlToken.equals(other.tlToken))
			return false;
		if (uId == null) {
			if (other.uId != null)
				return false;
		} else if (!uId.equals(other.uId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TokenLogin [tlToken = " + tlToken + ", uId = " + uId + ", expireDate = " + expireDate + ", modifyDate = " + modifyDate + ", modifyBy = " + modifyBy + ", createDatetime = " + createDatetime + ", createBy = " + createBy + "]";
	}

}
