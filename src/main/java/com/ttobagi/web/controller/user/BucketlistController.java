package com.ttobagi.web.controller.user;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.ttobagi.web.entity.Bucketlist;
import com.ttobagi.web.entity.Couple;
import com.ttobagi.web.service.BucketlistService;
import com.ttobagi.web.service.CoupleService;

@Controller
@RequestMapping("/user/bucketlist/")
public class BucketlistController {
	
	@Autowired
	private BucketlistService service;
	
	@Autowired
	private CoupleService coupleService;
	
	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", ""); 
	}
	
	@RequestMapping("list")
	public String list(Model model, HttpSession session){
		int id= (int)session.getAttribute("id");
		
		List<Couple> coupleList = coupleService.getList(id);
			
		int coupleId = coupleList.get(0).getId();
		
		List<Bucketlist> recommendList =service.getRandomList(1);
		List<Bucketlist> list =service.getList(coupleId,0);
		
		model.addAttribute("recommendList", recommendList);
		model.addAttribute("list", list);
		
		return "user.bucketlist.list";
	}
	
	
	@PostMapping("regs")
//	@ResponseStatus(value=HttpStatus.OK)
	public String regs(HttpServletRequest request, @RequestParam("file") MultipartFile mfile, @RequestParam("titlename") String cardTitle) throws IllegalStateException, IOException{
		//웹서비스 디렉토리의 물리적 경로 구하기
		String realPath = request.getSession().getServletContext().getRealPath("/resources/static/images/user/bucketlist/upload");
		//받아온 파일의 이름
		String OriginFileName= mfile.getOriginalFilename();
		//파일이름 암호화하기
		String saveFileName = getUuid() + OriginFileName;
		//물리적 경로에 파일 저장하기
		mfile.transferTo(new File(realPath+File.separator+saveFileName));
		
		service.insert(cardTitle,saveFileName); 
	
		return "redirect:list";
	}
	 
}
