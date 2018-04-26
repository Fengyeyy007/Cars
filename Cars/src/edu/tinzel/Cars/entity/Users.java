package edu.tinzel.Cars.entity;

import java.io.Serializable;

public class Users implements Serializable {
	private int userId;
	private String userName;
	private String loginName;
	private String loginPwd;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public Users(String userName, String loginName, String loginPwd) {
		super();
		this.userName = userName;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
	}
	public Users() {
		super();
	}
	
	public Users(int userId, String userName, String loginName, String loginPwd) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName
				+ ", loginName=" + loginName + ", loginPwd=" + loginPwd + "]";
	}
	
}
