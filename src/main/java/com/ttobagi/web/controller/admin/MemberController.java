package com.ttobagi.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.Document;

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
	public String list(Model model, 
			@RequestParam(name="search", defaultValue="") String search,
			@RequestParam(name="p", defaultValue="1") int page) {
		int rowNum = 10 * page - 10;
		
		List<MemberView> list = memberService.getViewList(page, 10, search, rowNum);
		int count = memberService.getCount(search);
		int coupleCount = memberService.getCoupleCount();
		//int singleCount = memberService.getSingleCount();
		int singleCount = count - (coupleCount * 2);
		int waitCount = memberService.getWaitCount();
		
		for (MemberView mv : list) {
			Couple couple = coupleService.get(mv.getId());

			if (couple != null)  // 커플을 요청했거나 응답대기중이라면
				if (couple.getApprovalDate() != null) // 커플이면
					mv.setIsCouple(true);
		}
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("coupleCount", coupleCount);
		model.addAttribute("singleCount", singleCount);
		model.addAttribute("waitCount", waitCount);
		
		
		return "admin.member.list";
	}
	
}
