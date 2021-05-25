package com.model;

import java.util.Date;

public class OpusInfo extends Opus {
	private String tname;
	private String sname;
	
	public OpusInfo() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public OpusInfo(int id, String author, String name, Date utime, String img, int ck, int tid, int sid,
			String introduce, String tname, String sname) {
		super(id, author, name, utime, img, ck, tid, sid, introduce);
		this.tname = tname;
		this.sname = sname;
	}
	
	public OpusInfo(int id, String author, String name, Date utime, String img, int ck, int tid, int sid,
			String introduce) {
		super(id, author, name, utime, img, ck, tid, sid, introduce);
		// TODO 自动生成的构造函数存根
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	
}
