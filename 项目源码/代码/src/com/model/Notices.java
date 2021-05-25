package com.model;

import java.util.Date;

public class Notices {
	private int id ; 
	private String owner ; 
	private String content ; 
	private Date showTime ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getShowTime() {
		return showTime;
	}
	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}
	public Notices(int id, String owner, String content, Date showTime) {
		super();
		this.id = id;
		this.owner = owner;
		this.content = content;
		this.showTime = showTime;
	}
	public Notices() {
		super();
	}
	@Override
	public String toString() {
		return "Notices [id=" + id + ", owner=" + owner + ", content=" + content + ", showTime=" + showTime + "]";
	} 
	
	
}
