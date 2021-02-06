package com.ttobagi.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttobagi.web.dao.MemberDao;
import com.ttobagi.web.entity.CoupleView;
import com.ttobagi.web.entity.Member;
import com.ttobagi.web.entity.MemberView;

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

	@Override
	public Member get(int id) {
		return memberDao.get(id);
	}

	@Override
	public int update(Member member) {
		return memberDao.update(member);
	}

	@Override
	public List<Member> getList(int offset, int size, String search) {
		return memberDao.getList(offset, size, search);
	}

	@Override
	public List<MemberView> getViewList(int page, int size, String search, int rowNum) {
		int offset = (page - 1) * 10;
		return memberDao.getViewList(offset, size, search, rowNum);
	}

	@Override
	public int getCount(String search) {
		return memberDao.getCount(search);
	}

	@Override
	public int getCoupleCount() {
		return memberDao.getCoupleCount();
	}

	@Override
	public int getSingleCount() {
		return memberDao.getSingleCount();
	}

	@Override
	public int getWaitCount() {
		return memberDao.getWaitCount();
	}

}
