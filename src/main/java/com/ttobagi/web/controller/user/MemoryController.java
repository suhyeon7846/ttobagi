package com.ttobagi.web.controller.user;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/memory")
public class MemoryController {
	
	@RequestMapping("list")
	public String list(Principal principal){
		
		return "user.memory.list";
	}
}
