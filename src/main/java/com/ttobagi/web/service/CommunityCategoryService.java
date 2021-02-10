package com.ttobagi.web.service;

import java.util.List;

import com.ttobagi.web.entity.Community;
import com.ttobagi.web.entity.CommunityCategory;
import com.ttobagi.web.entity.CommunityComment;
import com.ttobagi.web.entity.CommunityFiles;
import com.ttobagi.web.entity.CommunityView;

public interface CommunityCategoryService {
	//category
	List<CommunityCategory> getCateList();
	CommunityCategory getCategory(String type);
}
