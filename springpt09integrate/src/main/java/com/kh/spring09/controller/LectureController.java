package com.kh.spring09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring09.dao.LectureDao;
import com.kh.spring09.dto.LectureDto;

@Controller
@RequestMapping("/lecture")
public class LectureController {
	@Autowired
	private LectureDao lectureDao;
	
	@GetMapping("/insert")
	public String insert() {
		return "/WEB-INF/views/lecture/insert.jsp";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute LectureDto lectureDto) {
		lectureDao.insert(lectureDto);
//		return "redirect:/lecture/insert6"; //절대
		return "redirect:./insertComplete"; //상대
	}
	
	@RequestMapping("/insertComplete")
	public String insertComplete() {
		return "/WEB-INF/views/lecture/insertComplete.jsp";
	}
	
}
