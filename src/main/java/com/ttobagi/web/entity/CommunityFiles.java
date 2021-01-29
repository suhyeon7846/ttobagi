package com.ttobagi.web.entity;

public class CommunityFiles {
	private int id;
	private String name;
	private int communityId;
	
	public CommunityFiles() {
		// TODO Auto-generated constructor stub
	}

	public CommunityFiles(int id, String name, int communityId) {
		super();
		this.id = id;
		this.name = name;
		this.communityId = communityId;
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

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}

	@Override
	public String toString() {
		return "CommunityFiles [id=" + id + ", name=" + name + ", communityId=" + communityId + "]";
	}
}
