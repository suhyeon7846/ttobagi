package com.ttobagi.web.controller.api;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ttobagi.web.entity.Bucketlist;
import com.ttobagi.web.service.BucketlistService;

@RestController("apiBucketlistController")
@RequestMapping("/api/bucketlist/")
public class BucketlistController {
	
	@Autowired
	private BucketlistService service;
	
	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", ""); 
	}
	
	@RequestMapping("list")
	public List<Bucketlist> list(@RequestParam(name = "s",defaultValue = "1") int status){
		
		
		List<Bucketlist> list =service.getList(1,status);
		
		
		return list;
	}
	@RequestMapping("refresh")
	public List<Bucketlist> list(){
		
		int id =1;
		List<Bucketlist> recommendList =service.getRandomList(id);
		
		
		return recommendList;
	}
	@RequestMapping("update")
	public List<Bucketlist> update(
			@RequestParam(name = "c",defaultValue = "1") int cardId){
		
		service.update(cardId);
		
		List<Bucketlist> list =service.getList(1,0);
		
		
		return list;
	}
	
	@RequestMapping("delete")
	public List<Bucketlist> delete(
			@RequestParam(name = "c",defaultValue = "1") int cardId,
			@RequestParam(name = "s",defaultValue = "0") int status){
		
		service.delete(cardId);
		
		List<Bucketlist> list =service.getList(1,status);
		
		
		return list;
	}
	
	@RequestMapping("reg")
	public List<Bucketlist> reg(
			@RequestParam(name = "t",defaultValue = "제목없음") String cardTitle,
			@RequestParam(name = "p",defaultValue = "01") String picFile) {
		
		 service.insert(cardTitle,picFile); 
		
		List<Bucketlist> list =service.getList(1,0);
		
		return list;
	}
	
//	@PostMapping("regs")
////	@ResponseStatus(value=HttpStatus.OK)
//	public List<Bucketlist> regs(HttpServletRequest request, @RequestParam("file") MultipartFile mfile, @RequestParam("titlename") String cardTitle) throws IllegalStateException, IOException{
//		//웹서비스 디렉토리의 물리적 경로 구하기
//		String realPath = request.getSession().getServletContext().getRealPath("/resources/static/images/user/bucketlist/upload");
//		//받아온 파일의 이름
//		String OriginFileName= mfile.getOriginalFilename();
//		//파일이름 암호화하기
//		String saveFileName = getUuid() + OriginFileName;
//		//물리적 경로에 파일 저장하기
//		System.out.println("파일 저장  전");
//		mfile.transferTo(new File(realPath+File.separator+saveFileName));
//		System.out.println("인서트 전");
//		service.insert(cardTitle,saveFileName); 
//		
//		List<Bucketlist> list =service.getList(0);
//		
//		return list;
//	}
}
