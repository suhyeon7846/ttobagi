package com.ttobagi.web.entity;

import java.sql.Date;

public class Memory {

	private int id;
	private String content;
	private Date regDate;
	private int coupleId;
	private String fileName;
	
	public Memory() {
		
	}
	
	public Memory(int id, String content, Date regDate, int coupleId, String fileName) {
		super();
		this.id = id;
		this.content = content;
		this.regDate = regDate;
		this.coupleId = coupleId;
		this.fileName = fileName;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getcoupleId() {
		return coupleId;
	}

	public void setcoupleId(int coupleId) {
		this.coupleId = coupleId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "Memory [id=" + id + ", content=" + content + ", regDate=" + regDate + ", coupleId=" + coupleId
				+ ", fileName=" + fileName + "]";
	}
	
	
	
	
	
}
