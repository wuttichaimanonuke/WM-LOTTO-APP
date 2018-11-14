package com.wm.lotto.entity.roles;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Roles {

	private Integer rId;
	private String rName;
	private String rDescription;
	private String rActive;
	private Date modifyDate;
	private String modifyBy;
	private Date createDatetime;
	private String createBy;

	@JsonIgnore

	public Roles() {
		super();
	}

	public Roles(Integer rId, String rName, String rDescription, String rActive, Date modifyDate, String modifyBy, Date createDatetime, String createBy) {
		super();
		this.rId = rId;
		this.rName = rName;
		this.rDescription = rDescription;
		this.rActive = rActive;
		this.modifyDate = modifyDate;
		this.modifyBy = modifyBy;
		this.createDatetime = createDatetime;
		this.createBy = createBy;
	}

	public Integer getRId() {
		return rId;
	}

	public String getRName() {
		return rName;
	}

	public String getRDescription() {
		return rDescription;
	}

	public String getRActive() {
		return rActive;
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

	public void setRId(Integer rId) {
		this.rId = rId;
	}

	public void setRName(String rName) {
		this.rName = rName;
	}

	public void setRDescription(String rDescription) {
		this.rDescription = rDescription;
	}

	public void setRActive(String rActive) {
		this.rActive = rActive;
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
		result = prime * result + ((modifyBy == null) ? 0 : modifyBy.hashCode());
		result = prime * result + ((modifyDate == null) ? 0 : modifyDate.hashCode());
		result = prime * result + ((rActive == null) ? 0 : rActive.hashCode());
		result = prime * result + ((rDescription == null) ? 0 : rDescription.hashCode());
		result = prime * result + ((rId == null) ? 0 : rId.hashCode());
		result = prime * result + ((rName == null) ? 0 : rName.hashCode());
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
		Roles other = (Roles) obj;
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
		if (rActive == null) {
			if (other.rActive != null)
				return false;
		} else if (!rActive.equals(other.rActive))
			return false;
		if (rDescription == null) {
			if (other.rDescription != null)
				return false;
		} else if (!rDescription.equals(other.rDescription))
			return false;
		if (rId == null) {
			if (other.rId != null)
				return false;
		} else if (!rId.equals(other.rId))
			return false;
		if (rName == null) {
			if (other.rName != null)
				return false;
		} else if (!rName.equals(other.rName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Roles [rId = " + rId + ", rName = " + rName + ", rDescription = " + rDescription + ", rActive = " + rActive + ", modifyDate = " + modifyDate + ", modifyBy = " + modifyBy + ", createDatetime = " + createDatetime + ", createBy = " + createBy + "]";
	}

}