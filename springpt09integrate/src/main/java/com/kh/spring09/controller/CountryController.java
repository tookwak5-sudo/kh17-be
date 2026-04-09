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

import com.kh.spring09.dao.CountryDao;
import com.kh.spring09.dto.CountryDto;

@Controller
@RequestMapping("/country")
public class CountryController {
	@Autowired
	private CountryDao countryDao;
	
	//등록(화면과 처리 코드 결합)
	//- 예상되는 흐름 : [입력] -> [처리+출력]
//	@RequestMapping(value = "/insert", method = RequestMethod.GET)  // 21번줄하고 22번줄은 같은 코드
	@GetMapping("/insert")
	public String insert() {
		return "/WEB-INF/views/country/insert.jsp";
	}
//	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@PostMapping("/insert")
	public String insert(@ModelAttribute CountryDto countryDto) {
		countryDao.insert(countryDto);
//		return "redirect:/country/insert3.jsp"; //절대경로
		return "redirect:./insertComplete"; // 상대경로
		
	}
	@RequestMapping("/insertComplete")
	public String insertComplete() {
		return "/WEB-INF/views/country/insertComplete.jsp";
	}
	
	//목록 및 검색
	@RequestMapping("/list")
	public String list(Model model, 
			@RequestParam(required = false) String column, 
			@RequestParam(required = false) String keyword) {
		//리스트에 옮겨담고
		List<CountryDto> list = countryDao.selectList(column, keyword);
		//모델로 조회
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/country/list.jsp";
	}
}
