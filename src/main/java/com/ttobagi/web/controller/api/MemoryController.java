package com.ttobagi.web.controller.api;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ttobagi.web.entity.Couple;
import com.ttobagi.web.entity.Memory;
import com.ttobagi.web.service.CoupleService;
import com.ttobagi.web.service.MemoryService;

@RestController("apiMemoryController")
@RequestMapping("/api/memory/")
public class MemoryController {

	@Autowired
	private MemoryService service;
	
	@Autowired
	private CoupleService coupleService;
	
	@RequestMapping("list")
	public List<Memory> list(
				@RequestParam(name = "o",defaultValue = "키워드") String option,
				@RequestParam(name = "t",defaultValue = "") String text,
				HttpSession session){
		
		int id= (int)session.getAttribute("id");
		List<Couple> coupleList = coupleService.getList(id);
		int coupleId = coupleList.get(0).getId();
		List<Memory> list =  new ArrayList<>();
		if(option.equals("키워드")) {
			list = service.keywordList(coupleId,text);
		}else {
			list = service.dateList(coupleId, text);
		}
		
		return list;
	}
	
	@RequestMapping("delete")
	public List<Memory> delete(@RequestParam(name = "c",defaultValue = "1") int cardId,HttpSession session){
		int id= (int)session.getAttribute("id");
		List<Couple> coupleList = coupleService.getList(id);
		int coupleId = coupleList.get(0).getId();
		
		service.delete(cardId);
		
		List<Memory> list = service.getList(coupleId);
		
		return list;
	}
	
	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", ""); 
	}
	
	@GetMapping("edit")
	public List<Memory> edit(HttpServletRequest request, 
			@RequestParam("file") MultipartFile mfile, 
			@RequestParam("content") String content,
			@RequestParam("coupleId") int coupleId) throws IllegalStateException, IOException{
		//웹서비스 디렉토리의 물리적 경로 구하기
		String realPath = request.getSession().getServletContext().getRealPath("/resources/static/images/user/memory/upload");
		//받아온 파일의 이름
		String OriginFileName= mfile.getOriginalFilename();
		//파일이름 암호화하기
		String saveFileName = getUuid() + OriginFileName;
		//물리적 경로에 파일 저장하기
		mfile.transferTo(new File(realPath+File.separator+saveFileName));
		
		content = content.replace("\r\n", "<br >");
		
		
		List<Memory> list = service.getList(coupleId);
	
		return list;
	}
}
