package com.ttobagi.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttobagi.web.dao.BucketlistDao;
import com.ttobagi.web.entity.Bucketlist;

@Service
public class BucketlistServiceImp implements BucketlistService {

	@Autowired
	private BucketlistDao bucketlistDao;
	
	public BucketlistServiceImp() {
		
	}
	
	@Override
	public List<Bucketlist> getList() {
		
		return bucketlistDao.getList();
	}

}
