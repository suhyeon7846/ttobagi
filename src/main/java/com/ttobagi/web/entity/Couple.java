package com.ttobagi.web.entity;

import java.util.Date;

public class Couple {

	private int sender;
	private int receiver;
	private Date sendDate;
	private Date approvalDate;
	
	public Couple() {
		// TODO Auto-generated constructor stub
	}

	public Couple(int sender, int receiver, Date sendDate, Date approvalDate) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.sendDate = sendDate;
		this.approvalDate = approvalDate;
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
	
	
}
