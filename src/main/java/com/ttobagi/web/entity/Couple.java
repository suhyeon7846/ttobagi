package com.ttobagi.web.entity;

import java.sql.Date;

public class Couple {
	private int id;
	private int senderId;
	private int receiverId;
	private Date sendDate;
	private Date approvalDate;
	private Date loveStartDate;
	
	public Couple() {
		// TODO Auto-generated constructor stub
	}

	public Couple(int id, int senderId, int receiverId, Date sendDate, Date approvalDate, Date loveStartDate) {
		super();
		this.id = id;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.sendDate = sendDate;
		this.approvalDate = approvalDate;
		this.loveStartDate = loveStartDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
