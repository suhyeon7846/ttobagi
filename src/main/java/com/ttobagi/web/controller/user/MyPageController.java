package com.ttobagi.web.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ttobagi.web.entity.CoupleView;
import com.ttobagi.web.service.CoupleService;

@Controller
@RequestMapping("/user/")
public class MyPageController {

	@Autowired
	CoupleService coupleService;
	
	@GetMapping("mypage")
	public String mypage(HttpSession session, Model model) {
		
		if (session != null) {
			int id = (int)session.getAttribute("id");
			
			// param1: senderId, param2: receiverId
			CoupleView coupleView = coupleService.isApproval(id, 0); 
			
			model.addAttribute("coupleView", coupleView); // null이거나 불러오거나
			
//			if (couple == null) // 상대방이 응답을 하지않아 아직 커플이 성사되지 않은 경우
//				model.addAttribute("couple", null);
//			else
//				model.addAttribute("couple", couple);
		}
		return "user.mypage";
	}
}
