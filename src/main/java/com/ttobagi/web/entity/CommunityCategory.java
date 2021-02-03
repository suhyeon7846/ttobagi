package com.ttobagi.web.entity;

public class CommunityCategory {
	private int id;
	private String typeEnglishName;
	private String typeKoreanName;
	
	public CommunityCategory() {
		// TODO Auto-generated constructor stub
	}

	public CommunityCategory(int id, String typeEnglishName, String typeKoreanName) {
		super();
		this.id = id;
		this.typeEnglishName = typeEnglishName;
		this.typeKoreanName = typeKoreanName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeEnglishName() {
		return typeEnglishName;
	}

	public void setTypeEnglishName(String typeEnglishName) {
		this.typeEnglishName = typeEnglishName;
	}

	public String getTypeKoreanName() {
		return typeKoreanName;
	}

	public void setTypeKoreanName(String typeKoreanName) {
		this.typeKoreanName = typeKoreanName;
	}

	@Override
	public String toString() {
		return "CommunityCategory [id=" + id + ", typeEnglishName=" + typeEnglishName + ", typeKoreanName="
				+ typeKoreanName + "]";
	}
	
	
}
