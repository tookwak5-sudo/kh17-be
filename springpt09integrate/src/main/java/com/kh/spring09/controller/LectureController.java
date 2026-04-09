package com.kh.spring09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping("/list")
	public String list(Model model, 
						@RequestParam(required = false) String column, 
						@RequestParam(required = false) String keyword) {
		List<LectureDto> list = lectureDao.selectList(column, keyword);
		
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/lecture/list.jsp";
	}
	@RequestMapping("/detail")
	public String detail(Model model, @RequestParam int lectureNo) {
		LectureDto lecturDto = lectureDao.selectOne(lectureNo);
		
		model.addAttribute("lectureDto", lecturDto);
		return "/WEB-INF/views/lecture/detail.jsp";
	}
}
