package com.ttobagi.web.entity;

import java.sql.Date;

public class Letter {
	private int id;
	private int receiverId;
	private int senderID;
	private String title;
	private String content;
	private Date regdate;
	private int headerId;
	private int screenId;
	private int readCheckId;
	
	public Letter() {
		// TODO Auto-generated constructor stub
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

	public int getSenderID() {
		return senderID;
	}

	public void setSenderID(int senderID) {
		this.senderID = senderID;
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

	public int getHeaderId() {
		return headerId;
	}

	public void setHeaderId(int headerId) {
		this.headerId = headerId;
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public int getReadCheckId() {
		return readCheckId;
	}

	public void setReadCheckId(int readCheckId) {
		this.readCheckId = readCheckId;
	}

	@Override
	public String toString() {
		return "Letter [id=" + id + ", receiverId=" + receiverId + ", senderID=" + senderID + ", title=" + title
				+ ", content=" + content + ", regdate=" + regdate + ", headerId=" + headerId + ", screenId=" + screenId
				+ ", readCheckId=" + readCheckId + "]";
	}
	
	
	
	
}
