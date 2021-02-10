package com.ttobagi.web.entity;

import java.sql.Date;

public class Member {

	private int id;
	private String name;
	private String nickname;
	private String loginId;
	private String password;
	private String gender; 
	private String birthday;
	private String phone;
	private Date regDate;
	private String email;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(int id, String name, String nickname, String loginId, String password, String gender, String birthday,
			String phone, Date regDate) {
		super();
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.loginId = loginId;
		this.password = password;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.regDate = regDate;
	}

	public Member(int id, String name, String nickname, String loginId, String password, String gender, String birthday,
			String phone, Date regDate, String email) {
		super();
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.loginId = loginId;
		this.password = password;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.regDate = regDate;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", nickname=" + nickname + ", loginId=" + loginId + ", password="
				+ password + ", gender=" + gender + ", birthday=" + birthday + ", phone=" + phone + ", regDate="
				+ regDate + ", email=" + email + "]";
	}
	
	
	
	
	

	
}
