package com.ttobagi.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttobagi.web.dao.LetterDao;
import com.ttobagi.web.entity.Letter;
@Service
public class LetterServiceImp implements LetterService{

	@Autowired
	private LetterDao letterDao;
	
	public LetterServiceImp() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Letter> getList(int receiverId) {
		return letterDao.getList(receiverId);
	}
	
	@Override
	public List<Letter> getTitleReadCheckList(int receiverId) {
		// TODO Auto-generated method stub
		return letterDao.getTitelReadCheckList(receiverId);
	}

	@Override
	public int insert(Letter letter) {
		return letterDao.insert(letter);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return letterDao.delete(id);
	}

	

	@Override
	public int deleteAll(int[] del) {
		// TODO Auto-generated method stub
		return letterDao.deleteAll(del);
	}

	

	

}
