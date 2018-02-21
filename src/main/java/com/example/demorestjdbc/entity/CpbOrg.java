package com.example.demorestjdbc.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CpbOrg {

	private Long orgId;							//Primary key
	private String orgCode;						//Not null
	private String orgName;						//Not null
	private String orgSname;					//Not null
	private Long orgIdRef;						//Not null
	private Integer orgType;					//Not null
	private Integer status;						//Not null
	private String updateUser;
	private Date updateDateTime;
	private Integer dctmGroupRebuildStatus;		//Not null
	private Date dctmGroupRebuildDateTime;		//Not null
	
	public CpbOrg() {
		super();
	}

	public CpbOrg(Long orgId, String orgCode, String orgName, String orgSname, Long orgIdRef, Integer orgType,
			Integer status, String updateUser, Date updateDateTime, Integer dctmGroupRebuildStatus,
			Date dctmGroupRebuildDateTime) {
		super();
		this.orgId = orgId;
		this.orgCode = orgCode;
		this.orgName = orgName;
		this.orgSname = orgSname;
		this.orgIdRef = orgIdRef;
		this.orgType = orgType;
		this.status = status;
		this.updateUser = updateUser;
		this.updateDateTime = updateDateTime;
		this.dctmGroupRebuildStatus = dctmGroupRebuildStatus;
		this.dctmGroupRebuildDateTime = dctmGroupRebuildDateTime;
	}

	public Long getOrgId() {
		return orgId;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public String getOrgSname() {
		return orgSname;
	}

	public Long getOrgIdRef() {
		return orgIdRef;
	}

	public Integer getOrgType() {
		return orgType;
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

	public Integer getDctmGroupRebuildStatus() {
		return dctmGroupRebuildStatus;
	}

	public Date getDctmGroupRebuildDateTime() {
		return dctmGroupRebuildDateTime;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public void setOrgSname(String orgSname) {
		this.orgSname = orgSname;
	}

	public void setOrgIdRef(Long orgIdRef) {
		this.orgIdRef = orgIdRef;
	}

	public void setOrgType(Integer orgType) {
		this.orgType = orgType;
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

	public void setDctmGroupRebuildStatus(Integer dctmGroupRebuildStatus) {
		this.dctmGroupRebuildStatus = dctmGroupRebuildStatus;
	}

	public void setDctmGroupRebuildDateTime(Date dctmGroupRebuildDateTime) {
		this.dctmGroupRebuildDateTime = dctmGroupRebuildDateTime;
	}

	@Override
	public String toString() {
		return "CpbOrg [orgId=" + orgId + ", orgCode=" + orgCode + ", orgName=" + orgName + ", orgSname=" + orgSname
				+ ", orgIdRef=" + orgIdRef + ", orgType=" + orgType + ", status=" + status + ", updateUser="
				+ updateUser + ", updateDateTime=" + updateDateTime + ", dctmGroupRebuildStatus="
				+ dctmGroupRebuildStatus + ", dctmGroupRebuildDateTime=" + dctmGroupRebuildDateTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dctmGroupRebuildDateTime == null) ? 0 : dctmGroupRebuildDateTime.hashCode());
		result = prime * result + ((dctmGroupRebuildStatus == null) ? 0 : dctmGroupRebuildStatus.hashCode());
		result = prime * result + ((orgCode == null) ? 0 : orgCode.hashCode());
		result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
		result = prime * result + ((orgIdRef == null) ? 0 : orgIdRef.hashCode());
		result = prime * result + ((orgName == null) ? 0 : orgName.hashCode());
		result = prime * result + ((orgSname == null) ? 0 : orgSname.hashCode());
		result = prime * result + ((orgType == null) ? 0 : orgType.hashCode());
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
		CpbOrg other = (CpbOrg) obj;
		if (dctmGroupRebuildDateTime == null) {
			if (other.dctmGroupRebuildDateTime != null)
				return false;
		} else if (!dctmGroupRebuildDateTime.equals(other.dctmGroupRebuildDateTime))
			return false;
		if (dctmGroupRebuildStatus == null) {
			if (other.dctmGroupRebuildStatus != null)
				return false;
		} else if (!dctmGroupRebuildStatus.equals(other.dctmGroupRebuildStatus))
			return false;
		if (orgCode == null) {
			if (other.orgCode != null)
				return false;
		} else if (!orgCode.equals(other.orgCode))
			return false;
		if (orgId == null) {
			if (other.orgId != null)
				return false;
		} else if (!orgId.equals(other.orgId))
			return false;
		if (orgIdRef == null) {
			if (other.orgIdRef != null)
				return false;
		} else if (!orgIdRef.equals(other.orgIdRef))
			return false;
		if (orgName == null) {
			if (other.orgName != null)
				return false;
		} else if (!orgName.equals(other.orgName))
			return false;
		if (orgSname == null) {
			if (other.orgSname != null)
				return false;
		} else if (!orgSname.equals(other.orgSname))
			return false;
		if (orgType == null) {
			if (other.orgType != null)
				return false;
		} else if (!orgType.equals(other.orgType))
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
