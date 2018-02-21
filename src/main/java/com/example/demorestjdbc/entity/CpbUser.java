package com.example.demorestjdbc.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = false) 			//Ignore unknown properties.
@JsonInclude(JsonInclude.Include.NON_NULL)				//Properties is null, it not include to data model.
//@JsonInclude(JsonInclude.Include.NON_EMPTY)	
//@JsonIgnoreProperties({"properties1", "properties2"})	//Ignore multi properties.
public class CpbUser {
	
	private long userId; 			//Primary key
	private String userLogin; 		//Not Null
	private String userPass; 		//Not Null
	private String title; 			//Not Null
	private String fullName; 		//Not Null
	private String eMail; 			//Not Null
	private int	status; 			//Not Null
	private String updateUser;
	private Date updateDateTime;
	
	@JsonIgnore		//Ignore this value properties to data model. 
	//private String pt1;
	//private String pt2;
	/*
	Ex : 
	{"name":"Trish","dept","421 Moon Hill"}
	Employee{name='Trish', dept='Admin', address='null'}
	JSON input: {"name":"Trish","dept":"Admin", "address":"xyz Street"}
	Employee{name='Trish', dept='Admin', address='null'}
	*/
	
	
	public CpbUser() {
		super();
	}

	public CpbUser(long userId, String userLogin, String userPass, String title, String fullName, String eMail,
			int status, String updateUser, Date updateDateTime) {
		super();
		this.userId = userId;
		this.userLogin = userLogin;
		this.userPass = userPass;
		this.title = title;
		this.fullName = fullName;
		this.eMail = eMail;
		this.status = status;
		this.updateUser = updateUser;
		this.updateDateTime = updateDateTime;
	}

	public long getUserId() {
		return userId;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public String getUserPass() {
		return userPass;
	}

	public String getTitle() {
		return title;
	}

	public String getFullName() {
		return fullName;
	}

	public String geteMail() {
		return eMail;
	}

	public int getStatus() {
		return status;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public void setStatus(int status) {
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
		return "CpbUser [userId=" + userId + ", userLogin=" + userLogin + ", userPass=" + userPass + ", title=" + title
				+ ", fullName=" + fullName + ", eMail=" + eMail + ", status=" + status + ", updateUser=" + updateUser
				+ ", updateDateTime=" + updateDateTime + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + status;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((updateDateTime == null) ? 0 : updateDateTime.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
		result = prime * result + ((userLogin == null) ? 0 : userLogin.hashCode());
		result = prime * result + ((userPass == null) ? 0 : userPass.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CpbUser other = (CpbUser) obj;
		if (eMail == null) {
			if (other.eMail != null) {
				return false;
			}
		} else if (!eMail.equals(other.eMail)) {
			return false;
		}
		if (fullName == null) {
			if (other.fullName != null) {
				return false;
			}
		} else if (!fullName.equals(other.fullName)) {
			return false;
		}
		if (status != other.status) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		if (updateDateTime == null) {
			if (other.updateDateTime != null) {
				return false;
			}
		} else if (!updateDateTime.equals(other.updateDateTime)) {
			return false;
		}
		if (updateUser == null) {
			if (other.updateUser != null) {
				return false;
			}
		} else if (!updateUser.equals(other.updateUser)) {
			return false;
		}
		if (userId != other.userId) {
			return false;
		}
		if (userLogin == null) {
			if (other.userLogin != null) {
				return false;
			}
		} else if (!userLogin.equals(other.userLogin)) {
			return false;
		}
		if (userPass == null) {
			if (other.userPass != null) {
				return false;
			}
		} else if (!userPass.equals(other.userPass)) {
			return false;
		}
		return true;
	}

}
