package com.ttobagi.web.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ttobagi.web.entity.Couple;
import com.ttobagi.web.entity.Member;
import com.ttobagi.web.service.CoupleService;
import com.ttobagi.web.service.MemberService;

@RestController("apiCoupleController")
@RequestMapping("/api/couple/")
public class CoupleController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	CoupleService coupleService;
	
	@GetMapping("search")
	public Member search(HttpSession session, @RequestParam(name="rp") String receiverPhone) {
		Member receiver = memberService.getMemberByPhone(receiverPhone);
		
		if (session != null) {
			String senderPhone = (String)session.getAttribute("phone");
			if (senderPhone.equals(receiver.getPhone()))
				return null; // fetch문의 catch절로 빠짐
		}
		
		return receiver;
	}
	
	@GetMapping("list")
	public String get(HttpSession session, @RequestParam(name="receiverId", defaultValue="0") int receiverId) {
		Couple couple = null;
		int senderId = (int)session.getAttribute("id");
		
		if (session != null) {
			
			// 커플 요청 수신자가 요청받을 권한이 있는지 검사하는 경우
			if (receiverId != 0) {
				couple = coupleService.get(receiverId);
				
				if (couple == null) {
					coupleService.requestCouple(senderId, receiverId);
					return "true";
				}
				return null; // 커플등록이 되어있는 경우(fetch문의 catch절로 빠짐)
			}
			couple = coupleService.get(senderId);

			// 커플등록이 되어있지 않은 경우
			if (couple == null)
				return "true";

			return null; // 커플등록이 되어있는 경우(fetch문의 catch절로 빠짐)
		} 
		
		return "true";
	}
	
}
