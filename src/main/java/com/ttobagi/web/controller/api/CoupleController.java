package com.ttobagi.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ttobagi.web.entity.Member;
import com.ttobagi.web.service.CoupleService;

@RestController("apiCoupleController")
@RequestMapping("/api/couple/")
public class CoupleController {
	
	@Autowired
	CoupleService coupleService;
	
	@GetMapping("search")
	public String search(@RequestParam(name="phone", defaultValue="010-0000-0000") String phone ) {
		
		//Member member = coupleService.getMember(phone);
		
		return "";
	}
}
