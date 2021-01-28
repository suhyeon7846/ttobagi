package com.ttobagi.web.entity;

public class CommunityCategory {
	private int id;
	private String type;
	
	public CommunityCategory() {
		// TODO Auto-generated constructor stub
	}
	
	public CommunityCategory(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CommunityCategory [id=" + id + ", type=" + type + "]";
	}
}
