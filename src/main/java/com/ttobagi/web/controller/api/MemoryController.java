package com.ttobagi.web.controller.api;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.ttobagi.web.entity.Memory;
import com.ttobagi.web.service.MemoryService;

@RestController("apiMemoryController")
@RequestMapping("/api/memory/")
public class MemoryController {

	@Autowired
	private MemoryService service;
	
	@RequestMapping("list")
	public List<Memory> list(
				@RequestParam(name = "o",defaultValue = "키워드") String option,
				@RequestParam(name = "t",defaultValue = "") String text,
				HttpSession session){
		//session에 저장된 커플 아이디 가져오기
		int coupleId = (int)session.getAttribute("coupleId");
		
		List<Memory> list =  new ArrayList<>();
		if(option.equals("키워드")) {
			list = service.keywordList(coupleId,text);
		}else {
			list = service.dateList(coupleId, text);
		}
		
		return list;
	}
	
	@RequestMapping("delete")
	public List<Memory> delete(
				HttpServletRequest request,
				HttpSession session,
				@RequestParam(name = "c",defaultValue = "1") int cardId,
				@RequestParam(name="f") String saveFileName ){
		//session에 저장된 커플 아이디 가져오기
		int coupleId = (int)session.getAttribute("coupleId");
		
		//물리경로에 파일 지우기
		String realPath = request.getSession().getServletContext().getRealPath("/resources/static/images/user/memory/upload");
		
		String saveRealPath = realPath + File.separator + saveFileName;
		
		File deleteFile = new File(saveRealPath);
		
		if(deleteFile.exists()) {
			deleteFile.delete();
		}
		
		//DB에서 데이타 삭제 
		service.delete(cardId);
		
		List<Memory> list = service.getList(coupleId,0);
		
		return list;
	}
	//파일이름 암호화 
	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", ""); 
	}
	
	@PostMapping("edit")
	public List<Memory> edit(HttpServletRequest request, 
			@RequestParam(name="file", required=false) MultipartFile mfile,
			@RequestParam("content") String content,
			@RequestParam("id") int cardId,
			HttpSession session) throws IllegalStateException, IOException{
		//session에 저장된 커플 아이디 가져오기
		int coupleId = (int)session.getAttribute("coupleId");
		
		List<Memory> editcard = service.getList(coupleId,cardId);
		String preFIleName = editcard.get(0).getFileName();
		String saveFileName="";
		//파일을 선택했다면 새로 물리경로에 파일 저장
		if(mfile!=null){
			//웹서비스 디렉토리의 물리적 경로 구하기
			String realPath = request.getSession().getServletContext().getRealPath("/resources/static/images/user/memory/upload");
			
			//전에 등록된 파일 지우기
			String saveRealPath = realPath + File.separator + preFIleName;
			
			File deleteFile = new File(saveRealPath);
			
			if(deleteFile.exists()) {
				deleteFile.delete();
			}
			
			//새로 받아온 파일의 이름
			String OriginFileName= mfile.getOriginalFilename();
			//파일이름 암호화하기
			saveFileName = getUuid() + OriginFileName;
			//물리적 경로에 파일 저장하기
			mfile.transferTo(new File(realPath+File.separator+saveFileName));
		}
		
//		content = content.replace("\r\n", "<br >");
		
		service.update(cardId,content,saveFileName);
		
		List<Memory> list = service.getList(coupleId,0);
	
		return list;
	}
	
	@PostMapping("reg")
	public List<Memory> regs(HttpServletRequest request, 
			@RequestParam("file") MultipartFile mfile, 
			@RequestParam("content") String content,
			HttpSession session) throws IllegalStateException, IOException{
		
		//session에 저장된 커플 아이디 가져오기
		int coupleId = (int)session.getAttribute("coupleId");
		
		//웹서비스 디렉토리의 물리적 경로 구하기
		String realPath = request.getSession().getServletContext().getRealPath("/resources/static/images/user/memory/upload");
		//받아온 파일의 이름
		String OriginFileName= mfile.getOriginalFilename();
		//파일이름 암호화하기
		String saveFileName = getUuid() + OriginFileName;
		//물리적 경로에 파일 저장하기
		mfile.transferTo(new File(realPath+File.separator+saveFileName));
		
		content = content.replace("\r\n", "<br >");
		
		service.insert(content,saveFileName,coupleId); 
		List<Memory> list = service.getList(coupleId,0);
	
		return list;
	}
}
