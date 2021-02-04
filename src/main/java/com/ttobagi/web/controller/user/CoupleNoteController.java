package com.ttobagi.web.controller.user;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user/")
public class CoupleNoteController {
	
	@RequestMapping("coupleNote")
	public String coupleNote() {
		
		return "user.coupleNote";
	}
}
