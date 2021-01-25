package com.ttobagi.web.service;

import java.util.List;

import com.ttobagi.web.entity.Community;
import com.ttobagi.web.entity.CommunityCategory;

public interface CommunityService {

	List<CommunityCategory> getCateList();

	List<Community> getList(int id);
	
}
