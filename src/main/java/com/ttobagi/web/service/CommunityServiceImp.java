package com.ttobagi.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttobagi.web.dao.CommunityDao;
import com.ttobagi.web.entity.Community;
import com.ttobagi.web.entity.CommunityCategory;

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
	public List<Community> getList(int id) {
		// TODO Auto-generated method stub
		return communityDao.getList(id);
	}

}
