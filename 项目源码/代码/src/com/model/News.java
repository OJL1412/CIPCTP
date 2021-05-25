package com.model;

import java.util.Date;

public class News {
	private int id;
	private String title;
	private String author;
	private int state;
	private String content;
	private String img;
	private Date pubdate;
	private int ck;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Date getPubdate() {
		return pubdate;
	}
	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}
	public int getCk() {
		return ck;
	}
	public void setCk(int ck) {
		this.ck = ck;
	}
	
	public News(int id, String title, String author, int state, String content, String img, Date pubdate, int ck) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.state = state;
		this.content = content;
		this.img = img;
		this.pubdate = pubdate;
		this.ck = ck;
	}
	
	public News() {
		super();
	}
	
	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", author=" + author + ", state=" + state + ", content="
				+ content + ", img=" + img + ", pubdate=" + pubdate + ", ck=" + ck + "]";
	}
}
