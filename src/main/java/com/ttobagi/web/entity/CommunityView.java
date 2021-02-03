package com.ttobagi.web.entity;

import java.sql.Date;

public class CommunityView extends Community {
	private String communityEngType;
	private String communityKorType;
	private String memName;
	private String memNicName;
	private String memLoginId;
	private int fileId;
	private String fileName;
	
	public CommunityView() {
		super();
		
	}

	public CommunityView(int id, String title, String content, int memberId, int categoryId, Date regDate, int hit,
			int recomCnt, String communityEngType, String communityKorType, String memName, String memNicName,
			String memLoginId, int fileId, String fileName) {
		super(id, title, content, memberId, categoryId, regDate, hit, recomCnt);
		this.communityEngType = communityEngType;
		this.communityKorType = communityKorType;
		this.memName = memName;
		this.memNicName = memNicName;
		this.memLoginId = memLoginId;
		this.fileId = fileId;
		this.fileName = fileName;
		// TODO Auto-generated constructor stub
	}

	public String getCommunityEngType() {
		return communityEngType;
	}

	public void setCommunityEngType(String communityEngType) {
		this.communityEngType = communityEngType;
	}

	public String getCommunityKorType() {
		return communityKorType;
	}

	public void setCommunityKorType(String communityKorType) {
		this.communityKorType = communityKorType;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemNicName() {
		return memNicName;
	}

	public void setMemNicName(String memNicName) {
		this.memNicName = memNicName;
	}

	public String getMemLoginId() {
		return memLoginId;
	}

	public void setMemLoginId(String memLoginId) {
		this.memLoginId = memLoginId;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "CommunityView [communityEngType=" + communityEngType + ", communityKorType=" + communityKorType
				+ ", memName=" + memName + ", memNicName=" + memNicName + ", memLoginId=" + memLoginId + ", fileId="
				+ fileId + ", fileName=" + fileName + "]";
	}
	
}
