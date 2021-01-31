package com.ttobagi.web.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ttobagi.web.entity.Couple;
import com.ttobagi.web.service.CoupleService;

@Controller
@RequestMapping("/user/couple/")
public class CoupleController {
	
	@Autowired
	CoupleService coupleService;

	@GetMapping("reg")
	public String reg() {
		return "user.couple.reg";
	}
	
	@PostMapping("reg")
	public String reg(HttpSession session, @RequestParam(name="id") int receiverId) {
		if (session != null) {
			int senderId = (int)session.getAttribute("id");
			
			coupleService.requestCouple(senderId, receiverId);
		}
		return "redirect:../mypage";
	}
	
	@GetMapping("list")
	public String list() {
		return "user.couple.list";
	}
	
	@PostMapping("response")
	public String response(HttpSession session, String response) {
		
		if (session != null) {
			int id = (int)session.getAttribute("id");
			
			switch(response) {
				case "요청 수락":
					coupleService.responseOk(id); 
					// memberRole에 ROLE_COUPLE 추가하기, 그리고 로그인시 ROLE_COUPLE로 로그인되게 하기?
					break;
					
				case "요청 거절":
					coupleService.responseNo(id);
					break;
			}
		}
		return "redirect:/index";
	}
}