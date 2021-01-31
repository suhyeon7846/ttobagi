package com.ttobagi.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ttobagi.web.entity.Couple;
import com.ttobagi.web.entity.CoupleView;
import com.ttobagi.web.entity.Member;
import com.ttobagi.web.service.CoupleService;
import com.ttobagi.web.service.MemberService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	MemberService memberService;
	
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
				Member member = memberService.get(id);
				Couple couple = coupleService.get(id);
				CoupleView coupleView = null;
				
				if (couple == null) {
					model.addAttribute("notification", false);
					model.addAttribute("member", member);
					return "home.index";
				} 
				
				if (id == couple.getSenderId()) // 사용자가 sender인 경우
					model.addAttribute("notification", false);
				
				if (id == couple.getReceiverId()) { // 사용자가 receiver인 경우
					coupleView = coupleService.isApproval(0, id, false); 
					
					if (coupleView != null) {  // 응답을 하지 않았으므로 새로운 알림 존재
						model.addAttribute("notification", true);
						
						//CoupleView coupleView2 = coupleService.isNotApproval(0, id);
						model.addAttribute("coupleView", coupleView);
					} else  // 이미 커플이므로 새로운 알림 없음
						model.addAttribute("notification", false);
					
				}
				
			}
		}
		return "home.index";
	}
	
}
