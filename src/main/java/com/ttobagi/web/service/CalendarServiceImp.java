package com.ttobagi.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttobagi.web.dao.CalendarDao;
import com.ttobagi.web.entity.Calendar;

@Service
public class CalendarServiceImp implements CalendarService {
	
	@Autowired
	CalendarDao calendarDao;
	
	@Override
	public List<Calendar> getList(int id) {
		// TODO Auto-generated method stub
		return calendarDao.getList(id);
	}

}
