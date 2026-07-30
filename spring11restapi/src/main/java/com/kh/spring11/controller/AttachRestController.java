package com.kh.spring11.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring11.annotation.CommonsApiResponse;
import com.kh.spring11.service.AttachService;
import com.kh.spring11.vo.attach.AttachInfoVO;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "첨부파일 PI")
@CommonsApiResponse

@RestController
@RequestMapping("/api/attach")
public class AttachRestController {
	
	@Autowired
	private AttachService attachService;
	
	@GetMapping("/{attachNo}")
	public ResponseEntity<?> download(  //불확실한 경우 제너릭에 ?표시
			@PathVariable int attachNo
			) throws IOException{
		//[1] AttachService를 이용해서 파일과 파일 정보를 부른다
		AttachInfoVO vo = attachService.load(attachNo);
		
		//[2] 조회 결과를 이용해서 사용자에게 보낼 다운로드용 응답을 내보낸다
		//→ 다운로드 형식은 우리가 어찌할 수 없는 정해진 웹 통신 규격
		return ResponseEntity.ok()
				//헤더
				.header(HttpHeaders.CONTENT_ENCODING, "UTF-8")  //
				.header(HttpHeaders.CONTENT_TYPE, vo.getAttachDto().getAttachTypeString())
				
				//.header("Content-Length", vo.getAttachDto().getAttachSize()) 전용 메소드로 해결(why? 얘는 String이 아니어서)
				.contentLength(vo.getAttachDto().getAttachSize())
				
				//.header("Content-Disposition", "attachment; filename=000") //기존 파일명 띄어쓰기 한글명 처리가 안되었음(원래 통신은 UNICODE가 넘어가지 않음)
				.header(
					"Content-Disposition", 
					ContentDisposition
						.attachment()
						.filename(
								vo.getAttachDto().getAttachName(),
								StandardCharsets.UTF_8
						)
						.build().toString()
				)
				//바디
				.body(vo.getResource());
	}
}
