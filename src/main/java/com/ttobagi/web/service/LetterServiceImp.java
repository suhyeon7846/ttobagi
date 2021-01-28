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
	public int insert(Letter letter) {
		return letterDao.insert(letter);
	}

	

	

}
