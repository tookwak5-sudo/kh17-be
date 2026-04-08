package com.kh.spring07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring07.dao.LectureDao;
import com.kh.spring07.dto.LectureDto;

@RestController
@RequestMapping("/lecture") // 공용주소
public class Lecture_controller {
	
	@Autowired
	private LectureDao lectureDao;
	
	@RequestMapping("/insert") // 개별주소(공용주소와 합쳐짐)
	public String insert(@ModelAttribute LectureDto lectureDto) {
		lectureDao.insert(lectureDto);
		return "강좌 정보 등록이 완료되었습니다.";
	}
}
