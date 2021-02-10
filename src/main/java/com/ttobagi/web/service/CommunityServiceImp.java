package com.ttobagi.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttobagi.web.dao.CommunityDao;
import com.ttobagi.web.entity.Community;
import com.ttobagi.web.entity.CommunityCategory;
import com.ttobagi.web.entity.CommunityComment;
import com.ttobagi.web.entity.CommunityFiles;
import com.ttobagi.web.entity.CommunityView;

@Service
public class CommunityServiceImp implements CommunityService {

	@Autowired
	private CommunityDao communityDao; 
	
	@Override
	public List<Community> getList(int offset, int size, String type, String orderSet) {
		// TODO Auto-generated method stub
		return communityDao.getList(offset, size, type, orderSet);
	}

	@Override
	public Community get(int id) {
		// TODO Auto-generated method stub
		return communityDao.get(id);
	}
		
	@Override
	public int update(Community community) {
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
		System.out.println("service"+id);
		return communityDao.delete(id);
	}
	
	@Override
	public CommunityView getView(int id) {
		// TODO Auto-generated method stub
		return communityDao.getView(id);
	}

	@Override
	public List<CommunityView> getViewList(int offset, int size, String type, String orderSet) {
		return communityDao.getViewList(offset, size, type, orderSet);
	}
	
	@Override
	public CommunityFiles getFiles(int id) {
		// TODO Auto-generated method stub
		return communityDao.getFiles(id);
	}

	@Override
	public int insertFiles(CommunityFiles communityFiles) {
		// TODO Auto-generated method stub
		return communityDao.insertFiles(communityFiles);
	}

	@Override
	public int updateFiles(CommunityFiles communityFiles) {
		// TODO Auto-generated method stub
		return communityDao.updateFiles(communityFiles);
	}

	@Override
	public int deleteFiles(int id) {
		// TODO Auto-generated method stub
		return communityDao.deleteFiles(id);
	}

	@Override
	public int getLastNum() {
		return communityDao.getLastNum();
	}
}
