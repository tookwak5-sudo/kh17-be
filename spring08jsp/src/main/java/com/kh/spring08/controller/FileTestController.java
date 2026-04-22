package com.kh.spring08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring08.service.AttachService;

@Controller
@RequestMapping("/filetest")
public class FileTestController {
	
	@Autowired
	private AttachService attachService;
	
	@GetMapping("/uploadTest")
	public String uploadTest() {
		return "/WEB-INF/views/filetest/uploadTest.jsp";
	}
	
	//첨부파일을 받으려면 MultipartFile 이라는 형태를 작성해줘야한다(자동으로 application에 설정되지만, 제약조건(허용여부, 크기, 용량 등) 설정해주기)
	@PostMapping("/uploadTest")
	public String uploadTest(@RequestParam String uploader,
							@RequestParam MultipartFile attach) throws Exception {
		System.out.println("uploader= " + uploader);
		//System.out.println("uploader= " + attach);
		System.out.println("파일명 = " + attach.getOriginalFilename());
		System.out.println("파일유형 = " + attach.getContentType());
		System.out.println("파일크기 = " + attach.getSize());
		
		//byte[] data = attach.getBytes(); // 데이터 모두 추출
		//System.out.println("데이터 = " + Arrays.toString(data));
		
		//(주의) required 설정 여부과 관계없이 파일은 선택하지 않아도 MultipartFile 객체가 생긴다
		if(!attach.isEmpty()) {//파일이 있다면 < -- isEmpty()를 사용해 공백상태일 때를 처리
			attachService.save(attach); //DB + 파일저장
			
		}
		
		return "redirect:./uploadTest";
	}
}
