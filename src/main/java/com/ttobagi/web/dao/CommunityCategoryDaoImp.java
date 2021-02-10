package com.ttobagi.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttobagi.web.entity.Community;
import com.ttobagi.web.entity.CommunityCategory;
import com.ttobagi.web.entity.CommunityComment;
import com.ttobagi.web.entity.CommunityFiles;
import com.ttobagi.web.entity.CommunityView;

@Repository
public class CommunityCategoryDaoImp implements CommunityCategoryDao {
	
	private SqlSession session;
	private CommunityCategoryDao mapper;

	//생성자에서 미리 mapper 선언해둔다.
	@Autowired
	public CommunityCategoryDaoImp(SqlSession session) {
		this.session = session;
		mapper = session.getMapper(CommunityCategoryDao.class);
	}
	
	@Override
	public List<CommunityCategory> getCateList() {
		// TODO Auto-generated method stub
		return mapper.getCateList();
	}
	
	@Override
	public CommunityCategory getCategory(String type) {
		// TODO Auto-generated method stub
		return mapper.getCategory(type);
	}

}
