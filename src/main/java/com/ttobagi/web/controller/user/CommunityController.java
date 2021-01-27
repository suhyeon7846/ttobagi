package com.ttobagi.web.controller.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ttobagi.web.entity.Community;
import com.ttobagi.web.entity.CommunityCategory;
import com.ttobagi.web.entity.CommunityView;
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
	
	@PostMapping("upload")
	@ResponseBody
	public String upload(MultipartFile file) {

		System.out.println("file uploaded");
		System.out.println(file.getOriginalFilename());
		return "ok";
	}
	
	//list
	@GetMapping("{type}")
	public String list(Model model, @PathVariable("type") String type) {
		System.out.println(type);

		
		List<CommunityView> bestList = service.getViewList(0, 5, type, "hit");
		List<CommunityView> list = service.getViewList(0, 10, type, "regDate");
		
		model.addAttribute("bestList", bestList);
		model.addAttribute("list", list);
		
		return "user.community."+type+".list";
	}
	
	//detail
	@GetMapping("{type}/{id}")
	public String detail(Model model, @PathVariable("type") String type, @PathVariable("id") int id) {
		
		CommunityView communityView = service.getView(id);
		
		model.addAttribute("d", communityView);
		
		return "user.community."+type+".detail";
	}
	
	@GetMapping("{type}/{id}/edit")
	public String edit(Model model, @PathVariable("type") String type, @PathVariable("id") int id) {
		CommunityView list = service.getView(id);
		
		model.addAttribute("e", list);
		
		return "user.community."+type+".edit";
	}
	
	@PostMapping("{type}/{id}/edit")
	public String edit(Community community, @PathVariable("id") int id) {
		String title = community.getTitle();
		String content = community.getContent();
		
		Community origin = service.get(id);
		System.out.println(origin);
		origin.setTitle(title);
		origin.setContent(content);
		
		service.update(origin);
		
		return "redirect:../"+id;
	}
	
	@PostMapping("{type}/reg")
	public String reg(@PathVariable("type") String type) {
		//service.insert();
		return "redirect:../"+type+".list";
	}
	
	@GetMapping("{type}/{id}/del")
	public String delete(@PathVariable("type") String type, @PathVariable("id") int id) {
		service.delete(id);
		
		return "redirect:../"+type+".list";
	}
}
