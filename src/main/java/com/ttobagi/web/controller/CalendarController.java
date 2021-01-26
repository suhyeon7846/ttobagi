package com.ttobagi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/calendar/")
public class CalendarController {
	
	@GetMapping("{id}")
	public String list() {
		return "user.calendar.list";
	}

}
