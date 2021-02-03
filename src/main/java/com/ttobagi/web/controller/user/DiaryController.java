package com.ttobagi.web.controller.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ttobagi.web.entity.Couple;
import com.ttobagi.web.entity.DiaryView;
import com.ttobagi.web.service.CoupleService;
import com.ttobagi.web.service.DiaryService;
import com.ttobagi.web.service.MemberService;

@Controller
@RequestMapping("/user/diary")
public class DiaryController {
	
	@Autowired
	private DiaryService service;
	
	
	@Autowired
	private CoupleService coupleService;
	
	@RequestMapping("list")
	public String list(Model model, HttpSession session) {
		int id = (int)session.getAttribute("id");
		List<Couple> coupleList = coupleService.getList(id);
		int coupleId =coupleList.get(0).getId();
		
		System.out.println(coupleId);
		
//		List<DiaryView> list = service.getViewList();
		return "user.diary.list";
	}
	
	@RequestMapping("reg")
	public String reg() {
		return "user.diary.reg";
	}

}
