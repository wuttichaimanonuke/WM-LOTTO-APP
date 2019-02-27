package com.wm.lotto.entity.round_configure;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoundConfigure {

	private String rcfId;
	private Integer rYear;
	private Integer rMonth;
	private Integer rRound;
	private String rStatus;
	private Date modifyDate;
	private String modifyBy;
	private Date createDatetime;
	private String createBy;
	
	@JsonIgnore

	public RoundConfigure() {
		super();
	}

	public RoundConfigure(String rcfId, Integer rYear, Integer rMonth, Integer rRound, String rStatus, Date modifyDate,
			String modifyBy, Date createDatetime, String createBy) {
		super();
		this.rcfId = rcfId;
		this.rYear = rYear;
		this.rMonth = rMonth;
		this.rRound = rRound;
		this.rStatus = rStatus;
		this.modifyDate = modifyDate;
		this.modifyBy = modifyBy;
		this.createDatetime = createDatetime;
		this.createBy = createBy;
	}

	public String getRcfId() {
		return rcfId;
	}

	public void setRcfId(String rcfId) {
		this.rcfId = rcfId;
	}

	public Integer getrYear() {
		return rYear;
	}

	public void setrYear(Integer rYear) {
		this.rYear = rYear;
	}

	public Integer getrMonth() {
		return rMonth;
	}

	public void setrMonth(Integer rMonth) {
		this.rMonth = rMonth;
	}

	public Integer getrRound() {
		return rRound;
	}

	public void setrRound(Integer rRound) {
		this.rRound = rRound;
	}

	public String getrStatus() {
		return rStatus;
	}

	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
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
		result = prime * result + ((rMonth == null) ? 0 : rMonth.hashCode());
		result = prime * result + ((rRound == null) ? 0 : rRound.hashCode());
		result = prime * result + ((rStatus == null) ? 0 : rStatus.hashCode());
		result = prime * result + ((rYear == null) ? 0 : rYear.hashCode());
		result = prime * result + ((rcfId == null) ? 0 : rcfId.hashCode());
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
		RoundConfigure other = (RoundConfigure) obj;
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
		if (rMonth == null) {
			if (other.rMonth != null)
				return false;
		} else if (!rMonth.equals(other.rMonth))
			return false;
		if (rRound == null) {
			if (other.rRound != null)
				return false;
		} else if (!rRound.equals(other.rRound))
			return false;
		if (rStatus == null) {
			if (other.rStatus != null)
				return false;
		} else if (!rStatus.equals(other.rStatus))
			return false;
		if (rYear == null) {
			if (other.rYear != null)
				return false;
		} else if (!rYear.equals(other.rYear))
			return false;
		if (rcfId == null) {
			if (other.rcfId != null)
				return false;
		} else if (!rcfId.equals(other.rcfId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RoundConfigure [rcfId=" + rcfId + ", rYear=" + rYear + ", rMonth=" + rMonth + ", rRound=" + rRound
				+ ", rStatus=" + rStatus + ", modifyDate=" + modifyDate + ", modifyBy=" + modifyBy + ", createDatetime="
				+ createDatetime + ", createBy=" + createBy + "]";
	}
	
}