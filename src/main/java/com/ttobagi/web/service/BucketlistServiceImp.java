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
	public List<Bucketlist> getList(int id,int status) {
		
		return bucketlistDao.getList(id,status);
	}
	
	@Override
	public List<Bucketlist> getRandomList(int id) {
		return bucketlistDao.getRandomList(id);
	}
	
	@Override
	public int update(int cardId) {
		int result = bucketlistDao.update(cardId);
		return result;
	}

	@Override
	public int delete(int cardId) {
		int result = bucketlistDao.delete(cardId);
		return result;
	}

	@Override
	public int insert(String cardTitle, String picFile,int cId) {
		int result = bucketlistDao.insert(cardTitle,picFile,cId);
		return result;
	}



}
