package com.ttobagi.web.controller.api;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ttobagi.web.entity.Couple;
import com.ttobagi.web.entity.Memory;
import com.ttobagi.web.service.CoupleService;
import com.ttobagi.web.service.MemoryService;

@RestController("apiMemoryController")
@RequestMapping("/api/Memory/")
public class MemoryController {

	@Autowired
	private MemoryService service;
	
	@Autowired
	private CoupleService coupleService;
	
	@RequestMapping("delete")
	public List<Memory> delete(@RequestParam(name = "c",defaultValue = "1") int cardId,HttpSession session){
		int id= (int)session.getAttribute("id");
		List<Couple> coupleList = coupleService.getList(id);
		int coupleId = coupleList.get(0).getId();
		
		service.delete(cardId);
		List<Memory> list = service.getList(coupleId);
		
		return list;
	}
	
}
