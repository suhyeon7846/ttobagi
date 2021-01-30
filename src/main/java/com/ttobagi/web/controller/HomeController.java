package com.ttobagi.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ttobagi.web.entity.CoupleView;
import com.ttobagi.web.service.CoupleService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	CoupleService coupleService;
	
	@RequestMapping("index")
	public String index(HttpSession session, Model model) {
		
		// 왜 로그인을 안해도 session이 null아니지?
		if (session != null) {
			if (session.getAttribute("id") == null)
				return "home.index";
			else {
				int id = (int)session.getAttribute("id");
				CoupleView coupleView = coupleService.isApproval(0, id);
				
				model.addAttribute("coupleView", coupleView);
				
			}
		}
		
		return "home.index";
	}
	
}
