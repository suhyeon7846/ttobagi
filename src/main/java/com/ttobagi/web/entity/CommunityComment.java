package com.ttobagi.web.entity;

import java.sql.Date;

public class CommunityComment {
	private int id;
	private String nickname;
    private int memId;
    private String content;
    private Date regDate;
    private int communityId;
    
    public CommunityComment() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public CommunityComment(int id, String nickname, int memId, String content, Date regDate, int communityId) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.memId = memId;
		this.content = content;
		this.regDate = regDate;
		this.communityId = communityId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getMemId() {
		return memId;
	}

	public void setMemId(int memId) {
		this.memId = memId;
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

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}

	@Override
	public String toString() {
		return "CommunityComment [id=" + id + ", nickname=" + nickname + ", memId=" + memId + ", content=" + content
				+ ", regDate=" + regDate + ", communityId=" + communityId + "]";
	}

}
