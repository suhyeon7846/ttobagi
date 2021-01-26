package com.ttobagi.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttobagi.web.entity.Community;
import com.ttobagi.web.entity.CommunityCategory;
import com.ttobagi.web.entity.CommunityView;

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
	public List<CommunityView> getList(int id) {
		// TODO Auto-generated method stub
		return mapper.getList(id);
	}

	@Override
	public List<Community> getList(int offset, int size, String field, String query) {
		// TODO Auto-generated method stub
		return mapper.getList(offset, size, field, query);
	}

	@Override
	public int insert(Community community) {
		// TODO Auto-generated method stub
		return mapper.insert(community);
	}

	@Override
	public int update(Community community) {
		// TODO Auto-generated method stub
		return mapper.update(community);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return mapper.delete(id);
	}

}
