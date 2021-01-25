package com.ttobagi.web.dao;

import java.util.List;

import com.ttobagi.web.entity.Bucketlist;

public interface BucketlistDao {
	List<Bucketlist> getList(int status);

	int update(int cardId);

	int delete(int cardId);

	int insert(String cardTitle, String picFile);
}
