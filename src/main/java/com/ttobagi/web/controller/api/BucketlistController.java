package com.ttobagi.web.controller.api;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.ttobagi.web.entity.Couple;
import com.ttobagi.web.service.BucketlistService;
import com.ttobagi.web.service.CoupleService;

@RestController("apiBucketlistController")
@RequestMapping("/api/bucketlist/")
public class BucketlistController {
	
	@Autowired
	private BucketlistService service;
	
	@Autowired
	private CoupleService coupleService;
	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", ""); 
	}
	
	@RequestMapping("list")
	public List<Bucketlist> list(@RequestParam(name = "s",defaultValue = "1") int status,HttpSession session){
		int id= (int)session.getAttribute("id");
		List<Couple> coupleList = coupleService.getList(id);
		int coupleId = coupleList.get(0).getId();
		
		List<Bucketlist> list =service.getList(coupleId,status);
		
		
		return list;
	}
	@RequestMapping("refresh")
	public List<Bucketlist> recommendList(){
		
		List<Bucketlist> recommendList =service.getRandomList(1);
		
		
		return recommendList;
	}
	@RequestMapping("update")
	public List<Bucketlist> update(
			@RequestParam(name = "c",defaultValue = "1") int cardId,HttpSession session){
		
		int id= (int)session.getAttribute("id");
		List<Couple> coupleList = coupleService.getList(id);
		int coupleId = coupleList.get(0).getId();
		service.update(cardId);
		
		List<Bucketlist> list =service.getList(coupleId,0);
		
		
		return list;
	}
	
	@RequestMapping("delete")
	public List<Bucketlist> delete(
			@RequestParam(name = "c",defaultValue = "1") int cardId,
			@RequestParam(name = "s",defaultValue = "0") int status,
			HttpSession session){
		int id= (int)session.getAttribute("id");
		List<Couple> coupleList = coupleService.getList(id);
		int coupleId = coupleList.get(0).getId();
		service.delete(cardId);
		
		List<Bucketlist> list =service.getList(coupleId,status);
		
		
		return list;
	}
	
	@RequestMapping("reg")
	public List<Bucketlist> reg(
			@RequestParam(name = "t",defaultValue = "제목없음") String cardTitle,
			@RequestParam(name = "p",defaultValue = "01") String picFile,
			@RequestParam(name = "c") int coupleId,
			HttpSession session) { 
		 service.insert(cardTitle,picFile,coupleId); 
		System.out.println(coupleId);
		List<Bucketlist> list =service.getList(coupleId,0);
		
		return list;
	}
	
 
}
