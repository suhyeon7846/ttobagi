package com.ttobagi.web.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ttobagi.web.service.CoupleService;

@Controller
@RequestMapping("/user/couple/")
public class CoupleController {
	
	@Autowired
	CoupleService service;

	@GetMapping("reg")
	public String reg() {
		return "user.couple.reg";
	}
	
	@PostMapping("reg")
	public String reg(HttpServletRequest request, 
			@RequestParam(name="id") int receiverId) {
		HttpSession session = request.getSession();
		
		if (session != null) {
			int senderId = (int)session.getAttribute("id");
			
			service.requestCouple(senderId, receiverId);
		}
		
		return "redirect:reg";
	}
	
	@GetMapping("list")
	public String list() {
		return "user.couple.list";
	}
}