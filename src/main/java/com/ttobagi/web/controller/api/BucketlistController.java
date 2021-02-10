package com.ttobagi.web.controller.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
		
		List<Bucketlist> list =service.getList(coupleId,status,0);
		
		
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
		
		List<Bucketlist> list =service.getList(coupleId,0,0);
		
		
		return list;
	}
	
	@RequestMapping("delete")
	public List<Bucketlist> delete(HttpServletRequest request,
			@RequestParam(name = "c",defaultValue = "0") int cardId,
			@RequestParam(name = "s",defaultValue = "0") int status,
			HttpSession session){
		//session에 저장된 커플 아이디 가져오기
		int coupleId = (int)session.getAttribute("coupleId");
		List<Bucketlist> list2 = service.getList(coupleId,status,cardId);
		
		String saveFileName = list2.get(0).getFileName();
		//물리경로에 파일 지우기
				String realPath = request.getSession().getServletContext().getRealPath("/resources/static/images/user/bucketlist/upload");
				
				String saveRealPath = realPath + File.separator + saveFileName;
				
				File deleteFile = new File(saveRealPath);
				
				if(deleteFile.exists()) {
					deleteFile.delete();
				}
		service.delete(cardId);
		
		List<Bucketlist> list =service.getList(coupleId,status,0);
		
		
		return list;
	}
	
	@RequestMapping("reg")
	public List<Bucketlist> reg(HttpServletRequest request,
			@RequestParam(name = "t",defaultValue = "제목없음") String cardTitle,
			@RequestParam(name = "p",defaultValue = "01") String picFile,
			HttpSession session) throws IOException {
		//session에 저장된 커플 아이디 가져오기
		int coupleId = (int)session.getAttribute("coupleId");
		 
		//기존에 저장된 파일경로 가져오기
		String realPath = request.getSession().getServletContext().getRealPath("/resources/static/images/user/bucketlist/upload");
		
		String saveRealPath = realPath + File.separator + picFile;
		
		//파일객체생성
		File oriFile = new File(saveRealPath);
		
		//복사될 파일의 이름과 경로 생성
		String newFileName = getUuid()+".jpg";
		
		String newRealPath = realPath + File.separator + newFileName;
		//복사파일객체생성
		File copyFile = new File(newRealPath);
		
		FileInputStream fis = new FileInputStream(oriFile);//읽을파일
		FileOutputStream fos = new FileOutputStream(copyFile);//복사할파일
		 
		int fileByte = 0; 
         // fis.read()가 -1 이면 파일을 다 읽은것
         while((fileByte = fis.read()) != -1) {
             fos.write(fileByte);
         }
         //자원사용종료
         fis.close();
         fos.close();
		System.out.println("aaa");
		service.insert(cardTitle,newFileName,coupleId); 

		List<Bucketlist> list =service.getList(coupleId,0,0);
		
		return list;
	}
	
	@PostMapping("reg")
	public List<Bucketlist> regs(HttpServletRequest request,
			HttpSession session,
			@RequestParam("file") MultipartFile mfile, 
			@RequestParam("titleName") String cardTitle) throws IllegalStateException, IOException{
		//session에 저장된 커플 아이디 가져오기
		int coupleId = (int)session.getAttribute("coupleId");
		
		//웹서비스 디렉토리의 물리적 경로 구하기
		String realPath = request.getSession().getServletContext().getRealPath("/resources/static/images/user/bucketlist/upload");
		//받아온 파일의 이름
		String OriginFileName= mfile.getOriginalFilename();
		//파일이름 암호화하기
		String saveFileName = getUuid() + OriginFileName;
		//물리적 경로에 파일 저장하기
		mfile.transferTo(new File(realPath+File.separator+saveFileName));
		
		service.insert(cardTitle,saveFileName,coupleId); 
		
		List<Bucketlist> list =service.getList(coupleId,0,0);
		return list;
	}
 
}
