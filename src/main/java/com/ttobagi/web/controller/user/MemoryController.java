package com.ttobagi.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/memory")
public class MemoryController {
	
	@RequestMapping("list")
	public String list(){
		
		return "user.memory.list";
	}
}
