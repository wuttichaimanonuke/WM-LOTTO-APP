package com.example.demorestjdbc.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CpbUserRole {

	private Long userId;				//key
	private Long roleId;				//key
	private String updateUser;
	private Date updateDateTime;
	
	public CpbUserRole() {
		super();
	}

	public CpbUserRole(Long userId, Long roleId, String updateUser, Date updateDateTime) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.updateUser = updateUser;
		this.updateDateTime = updateDateTime;
	}

	public Long getUserId() {
		return userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	@Override
	public String toString() {
		return "CpbUserRole [userId=" + userId + ", roleId=" + roleId + ", updateUser=" + updateUser
				+ ", updateDateTime=" + updateDateTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((updateDateTime == null) ? 0 : updateDateTime.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		CpbUserRole other = (CpbUserRole) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (updateDateTime == null) {
			if (other.updateDateTime != null)
				return false;
		} else if (!updateDateTime.equals(other.updateDateTime))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
