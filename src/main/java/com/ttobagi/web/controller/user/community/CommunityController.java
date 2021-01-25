package com.ttobagi.web.controller.user.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ttobagi.web.entity.Community;
import com.ttobagi.web.entity.CommunityCategory;
import com.ttobagi.web.service.CommunityService;

@Controller
@RequestMapping("/user/community/")
public class CommunityController {
	
	@Autowired
	CommunityService service;
	
	@RequestMapping("index")
	public String index(Model model) {
		
		List<CommunityCategory> categoryType = service.getCateList();
		
		model.addAttribute("categorytype", categoryType);
		
		return "user.community.index";
	}
	
	@GetMapping("{type}")
	public String list(@PathVariable("type") String type) {
		System.out.println(type);
		return "user.community."+type+".list";
	}
	
	@GetMapping("{type}/{id}")
	public String detail(Model model, @PathVariable("type") String type, @PathVariable("id") int id) {
		
		List<Community> list = service.getList(id);
		
		model.addAttribute("list", list);
		
		return "user.community."+type+".detail";
	}
}
