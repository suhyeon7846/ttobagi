package com.ttobagi.web.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class Calendar {
	private int id;
	private Timestamp start;
	private Timestamp end;
	private String location;
	private String title;
	private String content;
	private Timestamp regdate;
	private int coupleId;
	
	public Calendar() {
		
	}

	public Calendar(int id, Timestamp start, Timestamp end, String location, String title, String content, Timestamp regdate,
			int coupleId) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
		this.location = location;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.coupleId = coupleId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getStart() {
		return start;
	}

	public void setStart(Timestamp start) {
		this.start = start;
	}

	public Timestamp getEnd() {
		return end;
	}

	public void setEnd(Timestamp end) {
		this.end = end;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public int getCoupleId() {
		return coupleId;
	}

	public void setCoupleId(int coupleId) {
		this.coupleId = coupleId;
	}

	@Override
	public String toString() {
		return "Calendar [id=" + id + ", start=" + start + ", end=" + end + ", location=" + location + ", title="
				+ title + ", content=" + content + ", regdate=" + regdate + ", coupleId=" + coupleId + "]";
	}
}
