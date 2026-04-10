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
import com.kh.spring09.exception.TargetNotfoundException;

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
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		if(lectureDto == null) throw new TargetNotfoundException("존재하지 않는 강좌 정보");
		model.addAttribute("lectureDto", lectureDto);
		return "/WEB-INF/views/lecture/detail.jsp";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam int lectureNo) {
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		if(lectureDto == null) throw new TargetNotfoundException("존재하지 않는 강좌 정보");
		
		lectureDao.delete(lectureNo);
		return "redirect:./list";
//		return "redirect:lecture/list";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam int lectureNo, Model model) {
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		if(lectureDto == null) throw new TargetNotfoundException("존재하지 않는 강좌 정보");
		
		model.addAttribute("lectureDto",lectureDto);
		return "/WEB-INF/views/lecture/edit.jsp";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute LectureDto lectureDto) {
		lectureDao.update(lectureDto);
		return "redirect:./detail?lectureNo=" + lectureDto.getLectureNo();
	}
}
