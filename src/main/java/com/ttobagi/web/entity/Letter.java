package com.ttobagi.web.entity;

import java.sql.Date;

public class Letter {
	private int id;
	private int receiverId;
	private int senderId;
	private String title;
	private String content;
	private Date regdate;
	private int readCheck;
	private Date senddate;
	
	
	public Letter() {
		// TODO Auto-generated constructor stub
	}


	public Letter(int id, int receiverId, int senderId, String title, String content, Date regdate, int readCheck,
			Date senddate) {
		super();
		this.id = id;
		this.receiverId = receiverId;
		this.senderId = senderId;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.readCheck = readCheck;
		this.senddate = senddate;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getReceiverId() {
		return receiverId;
	}


	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}


	

	public int getSenderId() {
		return senderId;
	}


	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	public int getReadCheck() {
		return readCheck;
	}


	public void setReadCheck(int readCheck) {
		this.readCheck = readCheck;
	}


	public Date getSenddate() {
		return senddate;
	}


	public void setSenddate(Date senddate) {
		this.senddate = senddate;
	}


	@Override
	public String toString() {
		return "Letter [id=" + id + ", receiverId=" + receiverId + ", senderID=" + senderId + ", title=" + title
				+ ", content=" + content + ", regdate=" + regdate + ", readCheckId=" + readCheck + ", senddate="
				+ senddate + "]";
	}

	
	
	
	
}
