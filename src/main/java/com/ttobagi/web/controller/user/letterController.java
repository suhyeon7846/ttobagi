package com.ttobagi.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/letter")
public class letterController {
	
	@RequestMapping("list")
	public String list() {
		return "user.letter.list";
	}
	
	@RequestMapping("reg")
	public String reg() {
		return "user.letter.reg";
	}
	
}
