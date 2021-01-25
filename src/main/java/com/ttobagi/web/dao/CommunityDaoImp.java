package com.ttobagi.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttobagi.web.entity.Community;
import com.ttobagi.web.entity.CommunityCategory;

@Repository
public class CommunityDaoImp implements CommunityDao {
	
	private SqlSession session;
	private CommunityDao mapper;

	//생성자에서 미리 mapper 선언해둔다.
	@Autowired
	public CommunityDaoImp(SqlSession session) {
		this.session = session;
		mapper = session.getMapper(CommunityDao.class);
	}
	
	@Override
	public List<CommunityCategory> getCateList() {
		// TODO Auto-generated method stub
		return mapper.getCateList();
	}

	@Override
	public List<Community> getList(int id) {
		// TODO Auto-generated method stub
		return mapper.getList(id);
	}

}
