package com.ttobagi.web.controller.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

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
//		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss", Locale.KOREA );
//		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//		for(Calendar c : list) {
//			try {
//				System.out.println(c.getStart());
//				c.setStart(transFormat.parse(formatter.format(c.getStart())));
//				System.out.println(c.getStart());
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		System.out.println(list.get(0).getRegdate());
		model.addAttribute("id",id);
		model.addAttribute("list",list);
		
		return list;
	}
	
	

}
