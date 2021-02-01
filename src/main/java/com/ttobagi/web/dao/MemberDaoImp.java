package com.ttobagi.web.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttobagi.web.entity.Member;

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
	
}
