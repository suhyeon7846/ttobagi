package com.ttobagi.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttobagi.web.entity.Couple;
import com.ttobagi.web.entity.CoupleView;
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

	@Override
	public List<Couple> getList(int id) {
		return mapper.getList(id);
	}

	@Override
	public Couple get(int id) {
		return mapper.get(id);
	}

	@Override
	public CoupleView isApproval(int senderId, int receiverId) {
		return mapper.isApproval(senderId, receiverId);
	}

	@Override
	public int responseOk(int receiverId) {
		return mapper.responseOk(receiverId);
	}

	@Override
	public int responseNo(int receiverId) {
		return mapper.responseNo(receiverId);
	}

	
}
