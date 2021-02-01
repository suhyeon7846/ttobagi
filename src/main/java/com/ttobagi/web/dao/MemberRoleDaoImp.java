package com.ttobagi.web.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRoleDaoImp implements MemberRoleDao {

	private SqlSession session;
	private MemberRoleDao mapper;
	
	@Autowired
	public MemberRoleDaoImp(SqlSession session) {
		this.session = session;
		mapper = session.getMapper(MemberRoleDao.class);
	}

	@Override
	public int insert(int id, int type) {
		return mapper.insert(id, type);
	}

	@Override
	public int delete(int id, int type) {
		return mapper.delete(id, type);
	}
}
