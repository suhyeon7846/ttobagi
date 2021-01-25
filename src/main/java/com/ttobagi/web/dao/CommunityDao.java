package com.ttobagi.web.dao;

import java.util.List;

import com.ttobagi.web.entity.Community;
import com.ttobagi.web.entity.CommunityCategory;

public interface CommunityDao {

	List<CommunityCategory> getCateList();
	List<Community> getList(int id);
}
