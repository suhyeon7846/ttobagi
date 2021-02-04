package com.ttobagi.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ttobagi.web.entity.Couple;
import com.ttobagi.web.entity.MemberView;
import com.ttobagi.web.service.CoupleService;
import com.ttobagi.web.service.MemberService;

@Controller
@RequestMapping("/admin/member/")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	CoupleService coupleService;
	
	@GetMapping("list")
	public String list(Model model, String search) {
		List<MemberView> list = null;
		System.out.println("search: " + search);
		if (search == null) {
			System.out.println(1);
			list = memberService.getList(1, 10, "");
			System.out.println(2);
		}
		list = memberService.getList(1, 10, search);
		
		System.out.println(list.get(0).getId());
		
		for (MemberView m : list) {
			Couple couple = coupleService.get(m.getId());
			System.out.println(couple.getId());

			if (couple != null)  // 커플을 요청했거나 응답대기중이라면
				if (couple.getApprovalDate() != null) // 커플이면
					m.setCouple(true);
		}
		
		model.addAttribute("list", list);
		
		return "admin.member.list";
	}
	
//	@GetMapping("detail/{id}")
//	public String detail(@PathVariable("id") int id) {
//		
//		return "admin.member.";
//	}
}
