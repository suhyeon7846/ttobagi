package com.ttobagi.web.controller.api;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ttobagi.web.entity.Letter;
import com.ttobagi.web.service.LetterService;
@RestController("apiLetterController")
@RequestMapping("/api/letter/")
public class LetterController {
	
	@Autowired
	private LetterService service;
	
	@RequestMapping("{id}")
//	public List<Letter> detail(
	public Letter detail(
	@PathVariable("id") int id) {
		
		Letter letter = service.get(id);
		System.out.println(letter.getReadCheck());
		if(letter.getReadCheck()==0)
			service.updateReadCheck(id);
		return letter;
//		return list;
		
	}
}
