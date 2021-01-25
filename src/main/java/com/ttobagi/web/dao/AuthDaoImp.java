package com.ttobagi.web.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttobagi.web.entity.Member;

@Repository
public class AuthDaoImp implements AuthDao {

	private AuthDao mapper;
	private SqlSession session;
	
	@Autowired
	public AuthDaoImp(SqlSession session) {
		this.session = session;
		mapper = session.getMapper(AuthDao.class);
	}

	@Override
	public int insert(Member member) {
		return mapper.insert(member);
	}
	
	@Override
	public int insertMemberRole(int memberId, int roleId) {
		return mapper.insertMemberRole(memberId, roleId);
	}

	@Override
	public int checkLoginId(String loginId) {
		return mapper.checkLoginId(loginId);
	}

	@Override
	public int checkNickname(String nickname) {
		return mapper.checkNickname(nickname);
	}

	@Override
	public int getLastId() {
		return mapper.getLastId();
	}

}
