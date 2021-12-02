package com.web.account.model;

public class AccountDTO {
	private String UserID;
	private String UserPassword;
	private String NewUserPassword;

	public AccountDTO() {
		this.UserID = "";
		this.UserPassword = "";
	}
	
	public AccountDTO(String UserID) {
		this.UserID = UserID;
	}
	
	public AccountDTO(String UserID, String UserPassword) {
		this.UserID = UserID;
		this.UserPassword = UserPassword;
	}
	
	public AccountDTO(String UserID, String UserPassword, String NewUserPassword) {
		this.UserID = UserID;
		this.UserPassword = UserPassword;
		this.NewUserPassword = NewUserPassword;
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
}
