package com.ttobagi.web.controller.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.ttobagi.web.entity.Calendar;
import com.ttobagi.web.service.CalendarService;

@Controller
@RequestMapping("/user/calendar/")
public class CalendarController {
	
	@Autowired
	private CalendarService service;
	
	@GetMapping("list")
	public String list(HttpSession session, Model model) {
		System.out.println(session.getAttribute("id"));
		int id = (int) session.getAttribute("id");
		model.addAttribute("id",id);
		return "user.calendar.list";
	}
	
	@GetMapping("{id}")
	@ResponseBody
	public List<Calendar> getList(@PathVariable(name="id") int id,HttpSession session, Model model) throws ParseException{
		
		List<Calendar> list = service.getList(id);
//		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss", Locale.KOREA );
//		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//		for(Calendar c : list) {
//			try {
//				System.out.println(c.getStart());
//				c.setStart(transFormat.parse(formatter.format(c.getStart())));
//				System.out.println(c.getStart());
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		//System.out.println(list.get(0).getEnd());
		//String day = "2015-12-14 15:21:12";
		
//		String dateFormat = "yyyy-MM-dd HH:mm:ss";
//		SimpleDateFormat df = new SimpleDateFormat(dateFormat);
		
		//Date date = df.parse(day);
		//System.out.println(date);
		
//		TimeZone tz;
//		tz = TimeZone.getTimeZone("Asia/Seoul"); df.setTimeZone(tz);
		System.out.println(list);
		
		//model.addAttribute("id",id);
		//model.addAttribute("list",list);
		
		return list;
	}
	
	@PostMapping("{id}/reg")
	@ResponseBody
	public int reg(@RequestBody String schedule, @PathVariable(name="id") int id) throws ParseException {
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(schedule);
		String title = element.getAsJsonObject().get("title").getAsString();
		String content = element.getAsJsonObject().get("content").getAsString();
		String location = element.getAsJsonObject().get("location").getAsString();
		String start = element.getAsJsonObject().get("start").getAsString();
		String end = element.getAsJsonObject().get("end").getAsString();
		
		start = start.replace("T", " ");
		end = end.replace("T", " ");
		
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		Date startDate = transFormat.parse(start);
		Date endDate = transFormat.parse(end);
		
		Calendar c = new Calendar();
		c.setContent(content);
		c.setTitle(title);
		c.setLocation(location);
		c.setStart(startDate);
		c.setEnd(endDate);
		c.setCoupleId(id);
		
		int result = service.reg(c);
		int lastId = service.getLastId();
		
		return lastId;
	}
	
	@GetMapping("{id}/delete")
	@ResponseBody
	public int delete(@PathVariable(name="id") int id) {
		
		int result = service.delete(id);
		
		return result;
	}
	
	@PostMapping("{id}/update")
	@ResponseBody
	public int update(@PathVariable(name="id") int id, @RequestBody String schedule) throws ParseException {
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(schedule);
		String title = element.getAsJsonObject().get("title").getAsString();
		String content = element.getAsJsonObject().get("content").getAsString();
		String location = element.getAsJsonObject().get("location").getAsString();
		String start = element.getAsJsonObject().get("start").getAsString();
		String end = element.getAsJsonObject().get("end").getAsString();
		
		start = start.replace("T", " ");
		end = end.replace("T", " ");
		
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		Date startDate = transFormat.parse(start);
		Date endDate = transFormat.parse(end);
		
		Calendar c = new Calendar();
		c.setContent(content);
		c.setTitle(title);
		c.setLocation(location);
		c.setStart(startDate);
		c.setEnd(endDate);
		c.setId(id);
		
		int result = service.update(c);
		
		return result;
	}

}
