package com.ttobagi.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttobagi.web.dao.MemberDao;
import com.ttobagi.web.entity.Member;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDao memberDao;
	
	@Override
	public Member getMemberByPhone(String phone) {
		return memberDao.getMemberByPhone(phone);
	}

	@Override
	public Member getMemberByLoginId(String loginId) {
		return memberDao.getMemberByLoginId(loginId);
	}

}
