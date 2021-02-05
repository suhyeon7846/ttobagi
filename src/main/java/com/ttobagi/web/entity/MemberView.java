package com.ttobagi.web.entity;

import java.sql.Date;

public class MemberView extends Member {

	private int rowNum;
	private boolean isCouple;
	
	public MemberView() {
	}

	public MemberView(int rowNum, boolean isCouple, int id, String name, String nickname, 
			String loginId, String password, String gender, 
			String birthday, String phone, Date 
			regDate) {
		
		super(id, name, nickname, loginId, password, gender, birthday, phone, regDate);
		
		this.rowNum = rowNum;
		this.isCouple = isCouple;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public boolean getIsCouple() {
		return isCouple;
	}

	public void setIsCouple(boolean isCouple) {
		this.isCouple = isCouple;
	}
	
}
