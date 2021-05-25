package com.model;

import java.util.Date;

public class Opus {

	private int id;
	private String author;
	private String name;
	private Date utime;
	private String img;
	private int ck;
	private int tid;
	private int sid;
	private String introduce;
	
	
	public Opus() {
		super();
	}
	
	public Opus(int id, String author, String name, Date utime, String img, int ck, int tid, int sid,
			String introduce) {
		super();
		this.id = id;
		this.author = author;
		this.name = name;
		this.utime = utime;
		this.img = img;
		this.ck = ck;
		this.tid = tid;
		this.sid = sid;
		this.introduce = introduce;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getUtime() {
		return utime;
	}
	public void setUtime(Date utime) {
		this.utime = utime;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getCk() {
		return ck;
	}
	public void setCk(int ck) {
		this.ck = ck;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	@Override
	public String toString() {
		return id + "##" + author + "##" + name + "##" + utime + "##" + img + "##" + ck + "##" + tid + "##" + sid + "##"
				+ introduce;
	}
	
}
