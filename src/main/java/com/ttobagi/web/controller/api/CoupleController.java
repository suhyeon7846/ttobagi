package com.ttobagi.web.controller.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ttobagi.web.entity.Member;
import com.ttobagi.web.service.MemberService;

@RestController("apiCoupleController")
@RequestMapping("/api/couple/")
public class CoupleController {
	
	@Autowired
	MemberService service;
	
	@GetMapping("search")
	public Member search(HttpServletRequest request, 
			@RequestParam(name="rp") String receiverPhone) {
		
		Member receiver = service.getMemberByPhone(receiverPhone);
		HttpSession session = request.getSession();
		
		if (session != null) {
			String senderPhone = (String)session.getAttribute("phone");
			if (senderPhone.equals(receiver.getPhone()))
				return null; // fetch문의 catch절로 빠짐
		}
		
		return receiver;
	}
}
