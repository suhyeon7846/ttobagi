package com.ttobagi.web.entity;

public class MemberRole {

	private int id;
	private int roleId;
	private int memberId;
	
	public MemberRole() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberRole(int id, int roleId, int memberId) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.memberId = memberId;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getRoleId() {
		return roleId;
	}
	
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	public int getMemberId() {
		return memberId;
	}
	
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	
}
