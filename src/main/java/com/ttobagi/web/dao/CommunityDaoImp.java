package com.ttobagi.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttobagi.web.entity.Community;
import com.ttobagi.web.entity.CommunityCategory;
import com.ttobagi.web.entity.CommunityFiles;
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
	public Community get(int id) {
		// TODO Auto-generated method stub
		return mapper.get(id);
	}

	@Override
	public CommunityView getView(int id) {
		// TODO Auto-generated method stub
		return mapper.getView(id);
	}

	@Override
	public List<Community> getList(int offset, int size, String type, String orderSet) {
		// TODO Auto-generated method stub
		return mapper.getList(offset, size, type, orderSet);
	}
	
	@Override
	public List<CommunityView> getViewList(int offset, int size, String type, String orderSet) {
		return mapper.getViewList(offset, size, type, orderSet);
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

	@Override
	public CommunityFiles getFiles(int id) {
		// TODO Auto-generated method stub
		return mapper.getFiles(id);
	}

	@Override
	public int insertFiles(CommunityFiles communityFiles) {
		// TODO Auto-generated method stub
		System.out.println(communityFiles);
		return mapper.insertFiles(communityFiles);
	}

	@Override
	public int updateFiles(CommunityFiles communityFiles) {
		// TODO Auto-generated method stub
		return mapper.updateFiles(communityFiles);
	}

	@Override
	public int deleteFiles(int id) {
		// TODO Auto-generated method stub
		return mapper.deleteFiles(id);
	}

	
}
