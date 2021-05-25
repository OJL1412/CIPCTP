package com.model;

import java.util.Date;

public class Tbl_Messages {
	private int id;
	private String name;
	private String content;
	private String phone;
	private Date mtime;
	public Tbl_Messages(String name, String content, String phone, Date mtime) {
		super();
		this.name = name;
		this.content = content;
		this.phone = phone;
		this.mtime = mtime;
	}
	public Tbl_Messages() {
		super();
	}
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getMtime() {
		return mtime;
	}
	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}
	@Override
	public String toString() {
		return "Tbl_Messages [id=" + id + ", name=" + name + ", content=" + content + ", phone=" + phone + ", mtime="
				+ mtime + "]";
	}
	
}
