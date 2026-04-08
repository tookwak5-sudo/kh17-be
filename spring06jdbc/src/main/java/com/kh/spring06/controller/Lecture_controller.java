package com.kh.spring06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06.dao.LectureDao;
import com.kh.spring06.dto.LectureDto;

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
	
	@RequestMapping("/update")
	public String update(@ModelAttribute LectureDto lectureDto) {
		boolean success = lectureDao.update(lectureDto);
		if(success) {
			return "강좌정보가 수정되었습니다.";
		}
		else {
			return "해당 강좌가 존재하지 않습니다.";
		}
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int lectureNo) {
		boolean success = lectureDao.delete(lectureNo);
		if(success) {
			return "해당 강좌가 삭제되었습니다.";
		}
		else {
			return "해당 강좌가 존재하지 않습니다.";
		}
	}
	
	@RequestMapping("/list")
	public String list( 
			@RequestParam(required = false) String column, 
			@RequestParam(required = false) String keyword) {
		List<LectureDto> list = lectureDao.selectList(column, keyword);
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("결과 수 : " + list.size()).append("<br>");
		for(LectureDto lectureDto : list) {
			buffer.append(lectureDto.getLectureTitle()).append("<br>");
		}
		return buffer.toString();
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int countryNo) {
		LectureDto lectureDto = lectureDao.selectOne(countryNo);
		
		if(lectureDto == null) {
			return "존재하지 않는 강좌 정보";
		}
		else {
			StringBuffer buffer = new StringBuffer();
			buffer.append(" [" + lectureDto.getLectureTitle() + "] 강좌정보 <br>");
			buffer.append("번호 : " + lectureDto.getLectureNo() + "<br>");
			buffer.append("가격 : " + lectureDto.getLecturePrice() + "<br>");
			return buffer.toString();
		}
	}	
}
