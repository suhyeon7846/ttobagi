package com.ttobagi.web.controller.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ttobagi.web.entity.Calendar;
import com.ttobagi.web.service.CalendarService;

@Controller
@RequestMapping("/user/calendar/")
public class CalendarController {
	
	@Autowired
	private CalendarService service;
	
	@GetMapping("list")
	public String list(HttpSession session, Model model) {
		int id = (int) session.getAttribute("id");
		model.addAttribute("id",id);
		return "user.calendar.list";
	}
	
	@GetMapping("{id}")
	@ResponseBody
	public List<Calendar> getList(HttpSession session, Model model){
		int id = (int) session.getAttribute("id");
		List<Calendar> list = service.getList(id);
		
		model.addAttribute("id",id);
		model.addAttribute("list",list);
		
		return list;
	}
	
	

}
