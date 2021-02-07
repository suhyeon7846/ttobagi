package com.ttobagi.web.dao;

import java.util.List;

import com.ttobagi.web.entity.Calendar;

public interface CalendarDao {
	List<Calendar> getList(int id);

	int insert(Calendar c);

	int delete(int id);
}
