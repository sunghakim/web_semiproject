package com.web.model;

public class AccountDTO {
	private String UserID;
	private String UserPassword;
	private String NewUserPassword;
	private Boolean Manager;

	public AccountDTO() {
		this.UserID = "";
		this.UserPassword = "";
		this.Manager = false;
	}
	
	public AccountDTO(String UserID) {
		this.UserID = UserID;
		this.Manager = false;
	}
	
	public AccountDTO(String UserID, String UserPassword) {
		this.UserID = UserID;
		this.UserPassword = UserPassword;
		this.Manager = false;
	}
	
	public AccountDTO(String UserID, String UserPassword, String NewUserPassword) {
		this.UserID = UserID;
		this.UserPassword = UserPassword;
		this.NewUserPassword = NewUserPassword;
		this.Manager = false;
	}
	
	public String getUserID() {
		return this.UserID;
	}

	public void setUserID(String UserID) {
		this.UserID = UserID;
	}

	public String getUserPassword() {
		return this.UserPassword;
	}

	public void setUserPassword(String UserPassword) {
		this.UserPassword = UserPassword;
	}
	
	public String getNewUserPassword() {
		return this.NewUserPassword;
	}

	public void setNewUserPassword(String NewUserPassword) {
		this.NewUserPassword = NewUserPassword;
	}
	public boolean getManager() {
		return this.Manager;
	}
	public void setManager(int Manager) {
		switch(Manager) {
		case (1)://관리자
			this.Manager = true;
			break;
		case (0)://일반회원
			this.Manager = false;
		}
	}
	public void setManager(boolean Manager) {
		this.Manager = Manager;
	}
}
