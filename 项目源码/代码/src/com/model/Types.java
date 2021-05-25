package com.model;

public class Types {
	private int id ; 
	private String name ; 
	private int parentId ;

	public Types() {
		super();
	}

	public Types(int id, String name, int parentId) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
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

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "Types [id=" + id + ", name=" + name + ", parentId=" + parentId + "]";
	} 
	
}
