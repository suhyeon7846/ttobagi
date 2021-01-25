package com.ttobagi.web.service;

import java.util.List;

import com.ttobagi.web.entity.Bucketlist;

public interface BucketlistService {
	
	List<Bucketlist> getList(int status);

	int update(int cardId);

	int delete(int cardId);

	int insert(String cardTitle, String picFile);
	
}
