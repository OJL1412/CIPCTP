package com.model;

import java.util.Date;

public class UserInfo extends BaseModel{
	private int id;
	private String name;
	private String pwd;
	private String phone;
	private int role_id;
	private Date loginTime ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	
	public UserInfo(Date createTime, Date updateTime, int id, String name, String pwd, String phone, int role_id,
			Date loginTime) {
		super(createTime, updateTime);
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
		this.role_id = role_id;
		this.loginTime = loginTime;
	}
	
	public UserInfo() {
		
	}
	
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", pwd=" + pwd + ", phone=" + phone + ", role_id=" + role_id
				+ ", loginTime=" + loginTime + "]";
	}
	
	
	
}
