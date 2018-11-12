package com.wm.lotto.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Users {

	private String uId;
	private String uUsername;
	private String uPassword;
	private String uDisplayName;
	private String uDiscription;
	private String uActive;
	private Date modifyDate;
	private String modifyBy;
	private Date createDatetime;
	private String createBy;
	
//	@JsonIgnore

	public Users() {
		super();
	}

	public Users(String uId, String uUsername, String uPassword, String uDisplayName, String uDiscription, String uActive, Date modifyDate, String modifyBy, Date createDatetime, String createBy) {
		super();
		this.uId = uId;
		this.uUsername = uUsername;
		this.uPassword = uPassword;
		this.uDisplayName = uDisplayName;
		this.uDiscription = uDiscription;
		this.uActive = uActive;
		this.modifyDate = modifyDate;
		this.modifyBy = modifyBy;
		this.createDatetime = createDatetime;
		this.createBy = createBy;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuUsername() {
		return uUsername;
	}

	public void setuUsername(String uUsername) {
		this.uUsername = uUsername;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getuDisplayName() {
		return uDisplayName;
	}

	public void setuDisplayName(String uDisplayName) {
		this.uDisplayName = uDisplayName;
	}

	public String getuDiscription() {
		return uDiscription;
	}

	public void setuDiscription(String uDiscription) {
		this.uDiscription = uDiscription;
	}

	public String getuActive() {
		return uActive;
	}

	public void setuActive(String uActive) {
		this.uActive = uActive;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createBy == null) ? 0 : createBy.hashCode());
		result = prime * result + ((createDatetime == null) ? 0 : createDatetime.hashCode());
		result = prime * result + ((modifyBy == null) ? 0 : modifyBy.hashCode());
		result = prime * result + ((modifyDate == null) ? 0 : modifyDate.hashCode());
		result = prime * result + ((uActive == null) ? 0 : uActive.hashCode());
		result = prime * result + ((uDiscription == null) ? 0 : uDiscription.hashCode());
		result = prime * result + ((uDisplayName == null) ? 0 : uDisplayName.hashCode());
		result = prime * result + ((uId == null) ? 0 : uId.hashCode());
		result = prime * result + ((uPassword == null) ? 0 : uPassword.hashCode());
		result = prime * result + ((uUsername == null) ? 0 : uUsername.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
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
		if (uActive == null) {
			if (other.uActive != null)
				return false;
		} else if (!uActive.equals(other.uActive))
			return false;
		if (uDiscription == null) {
			if (other.uDiscription != null)
				return false;
		} else if (!uDiscription.equals(other.uDiscription))
			return false;
		if (uDisplayName == null) {
			if (other.uDisplayName != null)
				return false;
		} else if (!uDisplayName.equals(other.uDisplayName))
			return false;
		if (uId == null) {
			if (other.uId != null)
				return false;
		} else if (!uId.equals(other.uId))
			return false;
		if (uPassword == null) {
			if (other.uPassword != null)
				return false;
		} else if (!uPassword.equals(other.uPassword))
			return false;
		if (uUsername == null) {
			if (other.uUsername != null)
				return false;
		} else if (!uUsername.equals(other.uUsername))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Users [uId=" + uId + ", uUsername=" + uUsername + ", uPassword=" + uPassword + ", uDisplayName="
				+ uDisplayName + ", uDiscription=" + uDiscription + ", uActive=" + uActive + ", modifyDate="
				+ modifyDate + ", modifyBy=" + modifyBy + ", createDatetime=" + createDatetime + ", createBy="
				+ createBy + "]";
	}

}
