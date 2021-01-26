package com.ttobagi.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttobagi.web.dao.CommunityDao;
import com.ttobagi.web.entity.Community;
import com.ttobagi.web.entity.CommunityCategory;
import com.ttobagi.web.entity.CommunityView;

@Service
public class CommunityServiceImp implements CommunityService {

	@Autowired
	private CommunityDao communityDao; 
	
	@Override
	public List<CommunityCategory> getCateList() {
		// TODO Auto-generated method stub
		return communityDao.getCateList();
	}

	@Override
	public List<CommunityView> getList(int id) {
		// TODO Auto-generated method stub
		return communityDao.getList(id);
	}

	@Override
	public List<Community> getList(int offset, int size, String field, String query) {
		// TODO Auto-generated method stub
		return communityDao.getList(offset, size, field, query);
	}
	
	@Override
	public int update(Community community) {
		// TODO Auto-generated method stub
		return communityDao.update(community);
	}
	
	@Override
	public int insert(Community community) {
		// TODO Auto-generated method stub
		return communityDao.insert(community);
	}
	
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return communityDao.delete(id);
	}
}
