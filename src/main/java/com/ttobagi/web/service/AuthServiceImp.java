package com.ttobagi.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttobagi.web.dao.AuthDao;
import com.ttobagi.web.entity.Member;

@Service
public class AuthServiceImp implements AuthService {

	@Autowired
	AuthDao authDao;

	@Override
	public int insert(Member member) {
		return authDao.insert(member);
	}

	@Override
	public int checkLoginId(String loginId) {
		return authDao.checkLoginId(loginId);
	}

	@Override
	public int checkNickname(String nickname) {
		return authDao.checkNickname(nickname);
	}
	
	
}
