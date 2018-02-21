package com.example.demorestjdbc.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CpbRoleJoinCpbRoleType extends CpbRole {

	private String rtName;			//Not null
	private String rtRemark;		//Not null
	private Integer crtStatus;		//Not null
	private Integer rtOrder;		//Not null
	
	public CpbRoleJoinCpbRoleType() {
		super();
	}
	
	public CpbRoleJoinCpbRoleType(Long roleId, Long orgId, Integer rtId, String roleName, Integer status,
			String updateUser, Date updateDateTime) {
		super(roleId, orgId, rtId, roleName, status, updateUser, updateDateTime);
	}

	public CpbRoleJoinCpbRoleType(String rtName, String rtRemark, Integer crtStatus, Integer rtOrder) {
		super();
		this.rtName = rtName;
		this.rtRemark = rtRemark;
		this.crtStatus = crtStatus;
		this.rtOrder = rtOrder;
	}

	public CpbRoleJoinCpbRoleType(Long roleId, Long orgId, Integer rtId, String roleName, Integer status,
			String updateUser, Date updateDateTime, String rtName, String rtRemark, Integer crtStatus,
			Integer rtOrder) {
		super(roleId, orgId, rtId, roleName, status, updateUser, updateDateTime);
		this.rtName = rtName;
		this.rtRemark = rtRemark;
		this.crtStatus = crtStatus;
		this.rtOrder = rtOrder;
	}

	public String getRtName() {
		return rtName;
	}

	public String getRtRemark() {
		return rtRemark;
	}

	public Integer getCrtStatus() {
		return crtStatus;
	}

	public Integer getRtOrder() {
		return rtOrder;
	}

	public void setRtName(String rtName) {
		this.rtName = rtName;
	}

	public void setRtRemark(String rtRemark) {
		this.rtRemark = rtRemark;
	}

	public void setCrtStatus(Integer crtStatus) {
		this.crtStatus = crtStatus;
	}

	public void setRtOrder(Integer rtOrder) {
		this.rtOrder = rtOrder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((crtStatus == null) ? 0 : crtStatus.hashCode());
		result = prime * result + ((rtName == null) ? 0 : rtName.hashCode());
		result = prime * result + ((rtOrder == null) ? 0 : rtOrder.hashCode());
		result = prime * result + ((rtRemark == null) ? 0 : rtRemark.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CpbRoleJoinCpbRoleType other = (CpbRoleJoinCpbRoleType) obj;
		if (crtStatus == null) {
			if (other.crtStatus != null)
				return false;
		} else if (!crtStatus.equals(other.crtStatus))
			return false;
		if (rtName == null) {
			if (other.rtName != null)
				return false;
		} else if (!rtName.equals(other.rtName))
			return false;
		if (rtOrder == null) {
			if (other.rtOrder != null)
				return false;
		} else if (!rtOrder.equals(other.rtOrder))
			return false;
		if (rtRemark == null) {
			if (other.rtRemark != null)
				return false;
		} else if (!rtRemark.equals(other.rtRemark))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CpbRoleJoinCpbRoleType [rtName=" + rtName + ", rtRemark=" + rtRemark + ", crtStatus=" + crtStatus
				+ ", rtOrder=" + rtOrder + ", toString()=" + super.toString() + "]";
	}
	
}
