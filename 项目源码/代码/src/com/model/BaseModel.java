package com.model;

import java.util.Date;

public class BaseModel {
	private Date createTime ; 
	private Date updateTime ;
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public BaseModel(Date createTime, Date updateTime) {
		super();
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	public BaseModel() {
		super();
	}

}
