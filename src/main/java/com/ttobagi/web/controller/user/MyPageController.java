package com.ttobagi.web.controller.user;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ttobagi.web.entity.Couple;
import com.ttobagi.web.entity.CoupleView;
import com.ttobagi.web.entity.Member;
import com.ttobagi.web.service.CoupleService;
import com.ttobagi.web.service.MemberRoleService;
import com.ttobagi.web.service.MemberService;

@Controller
@RequestMapping("/user/")
public class MyPageController {

	@Autowired
	MemberService memberService;
	
	@Autowired
	MemberRoleService memberRoleService;
	
	@Autowired
	CoupleService coupleService;
	
	@GetMapping("mypage")
	public String mypage(HttpSession session, Model model) {
		
		if (session != null) {
			int id = (int)session.getAttribute("id"); // 익명, sender, receiver
			Member member = memberService.get(id);
			Couple couple = coupleService.get(id);
			CoupleView coupleView = null;
			
			// sender, receiver도 아닌 경우
			if (couple == null) {
				model.addAttribute("noBoth", true);
				model.addAttribute("member", member);
				return "user.mypage";
			} 
			
			if (id == couple.getSenderId()) {// 사용자가 sender인 경우
				// receiver가 아직 응답이 없다면 null
				coupleView = coupleService.isApproval(id, 0, true); 
				
				if (coupleView == null) { // 응답이 아직 없어 커플이 아님
					model.addAttribute("senderButNotResponse", true);
				} else { // 커플이므로 상대방 정보 보여주기
					Member oppositeMember = memberService.get(coupleView.getReceiverId());
					model.addAttribute("oppositeMember", oppositeMember);
				}
			}
			
			if (id == couple.getReceiverId()) { // 사용자가 receiver인 경우
				coupleView = coupleService.isApproval(0, id, true); 
				
				if (coupleView == null) { // 응답을 하지 않아 아직 커플이 아님
					model.addAttribute("receiverButNotResponse", true);
				} else { // 커플이므로 상대방 정보 보여주기
					Member oppositeMember = memberService.get(coupleView.getSenderId());
					model.addAttribute("oppositeMember", oppositeMember);
				}
			}
			model.addAttribute("member", member);
			model.addAttribute("coupleView", coupleView); 
		}
		return "user.mypage";
	}
	
	@PostMapping("mypage/member/update")
	public String update(HttpSession session, Member member) {
		
		if (session != null) {
			int id = (int)session.getAttribute("id");
			Member origin = memberService.get(id);
			
			System.out.println(member.getPassword());
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			origin.setPassword(passwordEncoder.encode(member.getPassword())); // 기존 객체에 새롭게 바뀐 부분만 덮어씌워서 update하기
			
			memberService.update(origin);
		}
		
		return "redirect:../../mypage";
	}
	
	@PostMapping("mypage/couple/update")
	public String update(HttpSession session, Couple couple, String action) {
		
		if (session != null) {
			int id = (int)session.getAttribute("id");
			
			switch (action) {
				case "설정하기":
					Couple origin = coupleService.get(id);
					
					// String으로 넘어오는데 어떻게 Date 자료형에 들어갈 수 있지?
					Date loveStartDate = couple.getLoveStartDate();
					
					origin.setLoveStartDate(loveStartDate);
					coupleService.update(origin);
					break;
					
				case "커플 해제":
					Couple origin2 = coupleService.get(id);
					coupleService.delete(origin2.getId());
					
					if (origin2.getSenderId() == id) { 
						memberRoleService.delete(id, 2); // 'ROLE_COUPLE' 삭제
						memberRoleService.delete(origin2.getReceiverId(), 2);
					} else {
						memberRoleService.delete(id, 2);
						memberRoleService.delete(origin2.getSenderId(), 2);
					}
					return "redirect:/auth/logout";
			}
		}
		
		return "redirect:../../mypage";
	}
	
}
