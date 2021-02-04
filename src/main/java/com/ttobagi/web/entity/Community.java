package com.ttobagi.web.entity;

import java.sql.Date;

public class Community {
	private int id;
	private String title;
	private String content;
	private int memberId;
	private int categoryId;
	private Date regDate;
	private int hit;
	private int recomCnt;
	private int negativeCnt;

	public Community() {
		// TODO Auto-generated constructor stub
	}
	
	public Community(int id, String title, String content, int memberId, int categoryId, Date regDate, int hit,
			int recomCnt, int negativeCnt) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.memberId = memberId;
		this.categoryId = categoryId;
		this.regDate = regDate;
		this.hit = hit;
		this.recomCnt = recomCnt;
		this.negativeCnt = negativeCnt;
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
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getRecomCnt() {
		return recomCnt;
	}
	public void setRecomCnt(int recomCnt) {
		this.recomCnt = recomCnt;
	}

	public int getNegativeCnt() {
		return negativeCnt;
	}

	public void setNegativeCnt(int negativeCnt) {
		this.negativeCnt = negativeCnt;
	}

	@Override
	public String toString() {
		return "Community [id=" + id + ", title=" + title + ", content=" + content + ", memberId=" + memberId
				+ ", categoryId=" + categoryId + ", regDate=" + regDate + ", hit=" + hit + ", recomCnt=" + recomCnt
				+ ", negativeCnt=" + negativeCnt + "]";
	}

}
