package com.ttobagi.web.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttobagi.web.entity.Member;

@Repository
public class CoupleDaoImp implements CoupleDao {

	private CoupleDao mapper;
	private SqlSession session;
	
	@Autowired
	public CoupleDaoImp(SqlSession session) {
		this.session = session;
		mapper = session.getMapper(CoupleDao.class);
	}

	@Override
	public int requestCouple(int senderId, int receiverId) {
		return mapper.requestCouple(senderId, receiverId);
	}
	
}
