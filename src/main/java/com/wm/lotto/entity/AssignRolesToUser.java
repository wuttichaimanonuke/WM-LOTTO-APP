package com.wm.lotto.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssignRolesToUser {

	private Integer aruId;
	private Integer rId;
	private String uId;
	private String aruActive;
	private Date modifyDate;
	private String modifyBy;
	private Date createDatetime;
	private String createBy;

	@JsonIgnore

	public AssignRolesToUser() {
		super();
	}

	public AssignRolesToUser(Integer aruId, Integer rId, String uId, String aruActive, Date modifyDate, String modifyBy, Date createDatetime, String createBy) {
		super();
		this.aruId = aruId;
		this.rId = rId;
		this.uId = uId;
		this.aruActive = aruActive;
		this.modifyDate = modifyDate;
		this.modifyBy = modifyBy;
		this.createDatetime = createDatetime;
		this.createBy = createBy;
	}

	public Integer getAruId() {
		return aruId;
	}

	public Integer getRId() {
		return rId;
	}

	public String getUId() {
		return uId;
	}

	public String getAruActive() {
		return aruActive;
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

	public void setAruId(Integer aruId) {
		this.aruId = aruId;
	}

	public void setRId(Integer rId) {
		this.rId = rId;
	}

	public void setUId(String uId) {
		this.uId = uId;
	}

	public void setAruActive(String aruActive) {
		this.aruActive = aruActive;
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
		result = prime * result + ((aruActive == null) ? 0 : aruActive.hashCode());
		result = prime * result + ((aruId == null) ? 0 : aruId.hashCode());
		result = prime * result + ((createBy == null) ? 0 : createBy.hashCode());
		result = prime * result + ((createDatetime == null) ? 0 : createDatetime.hashCode());
		result = prime * result + ((modifyBy == null) ? 0 : modifyBy.hashCode());
		result = prime * result + ((modifyDate == null) ? 0 : modifyDate.hashCode());
		result = prime * result + ((rId == null) ? 0 : rId.hashCode());
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
		AssignRolesToUser other = (AssignRolesToUser) obj;
		if (aruActive == null) {
			if (other.aruActive != null)
				return false;
		} else if (!aruActive.equals(other.aruActive))
			return false;
		if (aruId == null) {
			if (other.aruId != null)
				return false;
		} else if (!aruId.equals(other.aruId))
			return false;
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
		if (rId == null) {
			if (other.rId != null)
				return false;
		} else if (!rId.equals(other.rId))
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
		return "AssignRolesToUser [aruId = " + aruId + ", rId = " + rId + ", uId = " + uId + ", aruActive = " + aruActive + ", modifyDate = " + modifyDate + ", modifyBy = " + modifyBy + ", createDatetime = " + createDatetime + ", createBy = " + createBy + "]";
	}

}
