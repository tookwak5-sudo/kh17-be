package com.kh.spring10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dao.LectureDao;
import com.kh.spring10.dto.LectureDto;

@CrossOrigin
@RestController
@RequestMapping("/api/lecture")
public class LectureRestController {
	@Autowired
	private LectureDao lectureDao;
	
//	기존의 등록(Controller)
//	→ 데이터 <form>을 통해서 전송됨 (form-data 방식)  // 즉, @ModelAttribute는 form형태의 데이터를 받는 방식
//	→ key1=value1&key2&value2&...			   // ajax나 이런 비동기 방식은 form이 아니라  json형식으로 전송됨
//	→ GET/POST 모두 위치만 다를 뿐 데이터의 형식이 같음 
//	@PostMapping("/insert")
//	public String insert(@ModelAttribute LectureDto lectureDto) {
//		lectureDao.insert(lectureDto);
//		return "redirect:./insertComplete";
//	}
	
//	리액트에 대응하는 등록(RestController)
//	→ 데이터가 AJAX 방식으로 전송 (application/json)
//	→ {"key1":"value1", "key2":"value2", ...}
//	→ POST처럼 Body가 존재하는 방식에서만 가능(즉, GET에서는 불가능)
	@PostMapping("/insert")
	public void insert(@RequestBody LectureDto lectureDto) {
		int lectureNo = lectureDao.sequence();
		lectureDto.setLectureNo(lectureNo);
		lectureDao.insert(lectureDto);
	}
	
	//crud중 r은 단순 조회인 안전한 작업이기 때문에 get방식 고수
	@GetMapping("/list")
	public List<LectureDto> list(){
		return lectureDao.selectList(1, 10000);
	}
}
