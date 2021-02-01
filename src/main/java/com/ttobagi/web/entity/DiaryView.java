package com.ttobagi.web.entity;

import java.util.Date;

public class DiaryView {
	
	private String title;
	private String content;
	private Date regDate;
	private int memberId;
	private int moodId;
	private int type;
	private String file;
	
	public DiaryView() {
		
	}
	
	public DiaryView(String title, String content, Date regDate, int memberId, int moodId, int type, String file) {
		super();
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.memberId = memberId;
		this.moodId = moodId;
		this.type = type;
		this.file = file;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "DiaryView [title=" + title + ", content=" + content + ", regDate=" + regDate + ", memberId=" + memberId
				+ ", moodId=" + moodId + ", type=" + type + ", file=" + file + "]";
	}
	
	
	
}
