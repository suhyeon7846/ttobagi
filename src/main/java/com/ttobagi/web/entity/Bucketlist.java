package com.ttobagi.web.entity;

import java.sql.Date;

public class Bucketlist {
	
	private int id;
	private String title;
	private String fileName;
	private String fileRoute;
	private int status;
	private Date regDate;
	private int coupleId;
	
	public Bucketlist(int id, String title, String fileName, String fileRoute, int status, Date regDate, int coupleId) {
		this.id = id;
		this.title = title;
		this.fileName = fileName;
		this.fileRoute = fileRoute;
		this.status = status;
		this.regDate = regDate;
		this.coupleId = coupleId;
	}

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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileRoute() {
		return fileRoute;
	}

	public void setFileRoute(String fileRoute) {
		this.fileRoute = fileRoute;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "Bucketlist [id=" + id + ", title=" + title + ", fileName=" + fileName + ", fileRoute=" + fileRoute
				+ ", status=" + status + ", regDate=" + regDate + ", coupleId=" + coupleId + "]";
	}
	
	
}
