package com.ttobagi.web.entity;

public class Letter {
	private int id;
	private int receiver;
	private int sender;
	private String title;
	private String content;
	
	public Letter() {
		// TODO Auto-generated constructor stub
	}
	
	public Letter(int id, int receiver, int sender, String title, String content) {
		super();
		this.id = id;
		this.receiver = receiver;
		this.sender = sender;
		this.title = title;
		this.content = content;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReceiver() {
		return receiver;
	}
	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}
	public int getSender() {
		return sender;
	}
	public void setSender(int sender) {
		this.sender = sender;
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
	@Override
	public String toString() {
		return "letter [id=" + id + ", receiver=" + receiver + ", sender=" + sender + ", title=" + title + ", content="
				+ content + "]";
	}
	
	
}
