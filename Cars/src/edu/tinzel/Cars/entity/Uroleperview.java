package edu.tinzel.Cars.entity;

import java.io.Serializable;

public class Uroleperview implements Serializable {
	private int userId;
	private int roleId;
	private int perviewId;
	private int perId;
	private String roleMark;
	private String userName;
	private String roleName;
	private String perviewName;
	private String perviewUrl;
	private String loginPwd;
	private String loginName;
	
	
	public Uroleperview(int userId, int roleId, String userName,
			String roleName, String loginPwd, String loginName) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.userName = userName;
		this.roleName = roleName;
		this.loginPwd = loginPwd;
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getPerviewId() {
		return perviewId;
	}
	public void setPerviewId(int perviewId) {
		this.perviewId = perviewId;
	}
	public int getPerId() {
		return perId;
	}
	public void setPerId(int perId) {
		this.perId = perId;
	}
	public String getRoleMark() {
		return roleMark;
	}
	public void setRoleMark(String roleMark) {
		this.roleMark = roleMark;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getPerviewName() {
		return perviewName;
	}
	public void setPerviewName(String perviewName) {
		this.perviewName = perviewName;
	}
	public String getPerviewUrl() {
		return perviewUrl;
	}
	public void setPerviewUrl(String perviewUrl) {
		this.perviewUrl = perviewUrl;
	}
	public Uroleperview(int userId, int roleId, int perviewId, int perId,
			String roleMark, String userName, String roleName,
			String perviewName, String perviewUrl) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.perviewId = perviewId;
		this.perId = perId;
		this.roleMark = roleMark;
		this.userName = userName;
		this.roleName = roleName;
		this.perviewName = perviewName;
		this.perviewUrl = perviewUrl;
	}
	public Uroleperview() {
		super();
	}
	
	public Uroleperview(int userId, int roleId, int perviewId, int perId,
			String roleMark, String userName, String roleName,
			String perviewName) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.perviewId = perviewId;
		this.perId = perId;
		this.roleMark = roleMark;
		this.userName = userName;
		this.roleName = roleName;
		this.perviewName = perviewName;
	}
	
	
	public Uroleperview(int roleId, int perviewId, String roleMark,
			String roleName, String perviewName) {
		super();
		this.roleId = roleId;
		this.perviewId = perviewId;
		this.roleMark = roleMark;
		this.roleName = roleName;
		this.perviewName = perviewName;
	}
	@Override
	public String toString() {
		return "Uroleperview [userId=" + userId + ", roleId=" + roleId
				+ ", perviewId=" + perviewId + ", perId=" + perId
				+ ", roleMark=" + roleMark + ", userName=" + userName
				+ ", roleName=" + roleName + ", perviewName=" + perviewName
				+ ", perviewUrl=" + perviewUrl + "]";
	}
	
}
