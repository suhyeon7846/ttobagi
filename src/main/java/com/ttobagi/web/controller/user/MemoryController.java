package com.ttobagi.web.controller.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ttobagi.web.entity.Couple;
import com.ttobagi.web.entity.Memory;
import com.ttobagi.web.service.CoupleService;
import com.ttobagi.web.service.MemoryService;

@Controller
@RequestMapping("/user/memory")
public class MemoryController {
	
	@Autowired
	private MemoryService service;
	
	@Autowired
	private CoupleService coupleService;
	
	@RequestMapping("list")
	public String list(Model model, HttpSession session){
		int id= (int)session.getAttribute("id");
		List<Couple> coupleList = coupleService.getList(id);
		int coupleId = coupleList.get(0).getId();
		
		session.setAttribute("coupleId", coupleId);
		
		
		List<Memory> list = service.getList(coupleId,0);
		
		model.addAttribute("list", list);
		
		return "user.memory.list";
	}

}
