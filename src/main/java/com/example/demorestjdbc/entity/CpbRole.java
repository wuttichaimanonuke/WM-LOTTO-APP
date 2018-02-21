package com.example.demorestjdbc.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CpbRole {

	private Long roleId;			//Primary key
	private Long orgId;				//Not Null
	private Integer rtId;			//Not Null
	private String roleName;		//Not Null
	private Integer status;			//Not Null
	private String updateUser;
	private Date updateDateTime;
	
	public CpbRole() {
		super();
	}

	public CpbRole(Long roleId, Long orgId, Integer rtId, String roleName, Integer status, String updateUser,
			Date updateDateTime) {
		super();
		this.roleId = roleId;
		this.orgId = orgId;
		this.rtId = rtId;
		this.roleName = roleName;
		this.status = status;
		this.updateUser = updateUser;
		this.updateDateTime = updateDateTime;
	}

	public Long getRoleId() {
		return roleId;
	}

	public Long getOrgId() {
		return orgId;
	}

	public Integer getRtId() {
		return rtId;
	}

	public String getRoleName() {
		return roleName;
	}

	public Integer getStatus() {
		return status;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public void setRtId(Integer rtId) {
		this.rtId = rtId;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	@Override
	public String toString() {
		return "CpbRole [roleId=" + roleId + ", orgId=" + orgId + ", rtId=" + rtId + ", roleName=" + roleName
				+ ", status=" + status + ", updateUser=" + updateUser + ", updateDateTime=" + updateDateTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
		result = prime * result + ((rtId == null) ? 0 : rtId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((updateDateTime == null) ? 0 : updateDateTime.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
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
		CpbRole other = (CpbRole) obj;
		if (orgId == null) {
			if (other.orgId != null)
				return false;
		} else if (!orgId.equals(other.orgId))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		if (rtId == null) {
			if (other.rtId != null)
				return false;
		} else if (!rtId.equals(other.rtId))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
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
		return true;
	}

}
