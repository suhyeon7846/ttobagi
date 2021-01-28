package com.ttobagi.web.entity;

import java.util.Date;

public class Diary {
	private int id;
	private String title;
	private String content;
	private Date regDate;
	private int memberId;
	private int moodId;
	
	public Diary() {
		// TODO Auto-generated constructor stub
	}
	
	public Diary(int id, String title, String content, Date regDate, int memberId, int moodId) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.memberId = memberId;
		this.moodId = moodId;
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
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getMoodId() {
		return moodId;
	}
	public void setMoodId(int moodId) {
		this.moodId = moodId;
	}
	@Override
	public String toString() {
		return "Diary [id=" + id + ", title=" + title + ", content=" + content + ", regDate=" + regDate + ", memberId="
				+ memberId + ", moodId=" + moodId + "]";
	}
	
	
}
