package com.ttobagi.web.controller.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ttobagi.web.entity.Community;
import com.ttobagi.web.entity.CommunityCategory;
import com.ttobagi.web.entity.CommunityFiles;
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
		CommunityFiles communityFiles = service.getFiles(id);
		
		model.addAttribute("d", communityView);
		model.addAttribute("f", communityFiles);
		
		return "user.community."+type+".detail";
	}
	
	@GetMapping("{type}/{id}/edit")
	public String edit(Model model, @PathVariable("type") String type, @PathVariable("id") int id) {
		CommunityView list = service.getView(id);
		CommunityFiles files = service.getFiles(id);
		
		model.addAttribute("e", list);
		model.addAttribute("f", files);
		
		return "user.community."+type+".edit";
	}
	
	@PostMapping("{type}/{id}/edit")
	public String edit(Community community,
					   //파일
					   HttpServletRequest request,
					   CommunityFiles communityFiles,
					   @PathVariable("id") int id,
					   @PathVariable("type") String type,
					   @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		
		String title = community.getTitle();
		String content = community.getContent();
		
		// 파일 업로드
		String url = "resources/static/images/user/community/"+type+"/"+id;
		String realPath = request.getServletContext().getRealPath(url);
		String fileName = file.getOriginalFilename();

		File realPathFile = new File(realPath);
		if( !realPathFile.exists())
			realPathFile.mkdirs();
		
		String uploadedFilePath = realPath + File.separator + fileName;
		File uploadedFile = new File(uploadedFilePath);

		file.transferTo(uploadedFile);

		Community origin = service.get(id);
		origin.setTitle(title);
		origin.setContent(content);
		
		communityFiles.setName(fileName);
		communityFiles.setCommunityId(id);
		
		
		service.insertFiles(communityFiles);
		service.update(origin);

		return "redirect:../"+id;
	}
	
	@PostMapping("{type}/reg")
	public String reg(@PathVariable("type") String type) {
		//service.insert();
		return "redirect:../"+type+"/list";
	}
	
	@GetMapping("{type}/{id}/del")
	public String delete(
			@PathVariable("type") String type, 
			@PathVariable("id") int id) {
		
		service.delete(id);
		service.deleteFiles(id);
		
		return "redirect:../../"+type;
	}
}
