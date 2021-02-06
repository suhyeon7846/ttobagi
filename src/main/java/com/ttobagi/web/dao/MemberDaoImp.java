package com.ttobagi.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttobagi.web.entity.CoupleView;
import com.ttobagi.web.entity.Member;
import com.ttobagi.web.entity.MemberView;

@Repository
public class MemberDaoImp implements MemberDao {

	private SqlSession session;
	private MemberDao mapper;
	
	@Autowired
	public MemberDaoImp(SqlSession session) {
		this.session = session;
		mapper = session.getMapper(MemberDao.class);
	}
	
	@Override
	public Member getMemberByPhone(String phone) {
		return mapper.getMemberByPhone(phone);
	}

	@Override
	public Member getMemberByLoginId(String loginId) {
		return mapper.getMemberByLoginId(loginId);
	}

	@Override
	public Member get(int id) {
		return mapper.get(id);
	}

	@Override
	public int update(Member member) {
		return mapper.update(member);
	}

	@Override
	public List<MemberView> getViewList(int offset, int size, String search, int rowNum) {
		return mapper.getViewList(offset, size, search, rowNum);
	}

	@Override
	public List<Member> getList(int offset, int size, String search) {
		return mapper.getList(offset, size, search);
	}

	@Override
	public int getCount(String search) {
		return mapper.getCount(search);
	}

	@Override
	public int getCoupleCount() {
		return mapper.getCoupleCount();
	}

	@Override
	public int getSingleCount() {
		return mapper.getSingleCount();
	}

	@Override
	public int getWaitCount() {
		return mapper.getWaitCount();
	}
	
}
