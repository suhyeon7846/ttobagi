package com.ttobagi.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttobagi.web.dao.CommunityCategoryDao;
import com.ttobagi.web.dao.CommunityDao;
import com.ttobagi.web.entity.Community;
import com.ttobagi.web.entity.CommunityCategory;
import com.ttobagi.web.entity.CommunityComment;
import com.ttobagi.web.entity.CommunityFiles;
import com.ttobagi.web.entity.CommunityView;

@Service
public class CommunityCategoryServiceImp implements CommunityCategoryService {

	@Autowired
	private CommunityCategoryDao communityCategoryDao; 
	
	@Override
	public List<CommunityCategory> getCateList() {
		// TODO Auto-generated method stub
		return communityCategoryDao.getCateList();
	}
	
	@Override
	public CommunityCategory getCategory(String type) {
		// TODO Auto-generated method stub
		return communityCategoryDao.getCategory(type);
	}

}
