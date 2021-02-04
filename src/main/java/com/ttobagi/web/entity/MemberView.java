package com.ttobagi.web.entity;

import java.sql.Date;

public class MemberView extends Member {

	private boolean isCouple;
	
	public MemberView() {
	}

	public MemberView(boolean isCouple, int id, String name, String nickname, 
			String loginId, String password, String gender, 
			String birthday, String phone, Date 
			regDate) {
		
		super(id, name, nickname, loginId, password, gender, birthday, phone, regDate);
		
		this.isCouple = isCouple;
	}

	public boolean isCouple() {
		return isCouple;
	}

	public void setCouple(boolean isCouple) {
		this.isCouple = isCouple;
	}
	
}
