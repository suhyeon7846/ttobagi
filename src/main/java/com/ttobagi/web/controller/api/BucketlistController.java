package com.ttobagi.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ttobagi.web.entity.Bucketlist;
import com.ttobagi.web.service.BucketlistService;

@RestController("apiBucketlistController")
@RequestMapping("/api/bucketlist/")
public class BucketlistController {
	
	@Autowired
	private BucketlistService service;
	@RequestMapping("list")
	public List<Bucketlist> list(@RequestParam(name = "s",defaultValue = "1") int status){
		
		
		List<Bucketlist> list =service.getList(status);
		
		
		return list;
	}
	@RequestMapping("update")
	public List<Bucketlist> update(
			@RequestParam(name = "c",defaultValue = "1") int cardId){
		
		service.update(cardId);
		
		List<Bucketlist> list =service.getList(0);
		
		
		return list;
	}
	
	@RequestMapping("delete")
	public List<Bucketlist> delete(
			@RequestParam(name = "c",defaultValue = "1") int cardId,
			@RequestParam(name = "s",defaultValue = "0") int status){
		
		service.delete(cardId);
		
		List<Bucketlist> list =service.getList(status);
		
		
		return list;
	}
	
	@RequestMapping("reg")
	public List<Bucketlist> reg(
			@RequestParam(name = "t",defaultValue = "제목없음") String cardTitle,
			@RequestParam(name = "p",defaultValue = "01") String picFile) {
		
		 service.insert(cardTitle,picFile); 
		
		List<Bucketlist> list =service.getList(0);
		
		return list;
	}
}
