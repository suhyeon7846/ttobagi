package com.ttobagi.web.entity;

import java.util.Date;

public class Couple {
	private int id;
	private int sender;
	private int receiver;
	private Date sendDate;
	private Date approvalDate;
	private Date loveStartDate;
	
	public Couple() {
		// TODO Auto-generated constructor stub
	}

	public Couple(int id,int sender, int receiver, Date sendDate, Date approvalDate, Date loveStartDate) {
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
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

	public int getSender() {
		return sender;
	}

	public void setSender(int sender) {
		this.sender = sender;
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
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
