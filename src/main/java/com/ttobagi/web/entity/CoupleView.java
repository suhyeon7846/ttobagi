package com.ttobagi.web.entity;

import java.sql.Date;

public class CoupleView extends Member {
	private int coupleId;
	private int senderId;
	private int receiverId;
	private Date sendDate;
	private Date approvalDate;
	private Date loveStartDate;
	
	public CoupleView() {
		// TODO Auto-generated constructor stub
	}
	
	public CoupleView(
			int id, String name, String nickname, String loginId, String password, String gender, String birthday, String phone, Date regDate,
			int coupleId, int senderId, int receiverId, Date sendDate, Date approvalDate, Date loveStartDate) {
		super(id, name, nickname, loginId, password, gender, birthday, phone, regDate);
		this.coupleId = coupleId;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.sendDate = sendDate;
		this.approvalDate = approvalDate;
		this.loveStartDate = loveStartDate;
	}

	public int getCoupleId() {
		return coupleId;
	}

	public void setCoupleId(int coupleId) {
		this.coupleId = coupleId;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public Date getLoveStartDate() {
		return loveStartDate;
	}

	public void setLoveStartDate(Date loveStartDate) {
		this.loveStartDate = loveStartDate;
	}
	
	
	
	
}
