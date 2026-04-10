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
import com.kh.spring09.exception.TargetNotfoundException;

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
	
	//상세조회 매핑
	@RequestMapping("/detail")
	public String detail(Model model, @RequestParam int countryNo) {
		CountryDto countryDto = countryDao.selectOne(countryNo);
		//잘못된 번호인 경우(countryDto==null) 이를 오류(500)로 처리하고 싶습니다.
		if(countryDto == null) {
			throw new TargetNotfoundException("존재하지 않는 국가");
		}
		model.addAttribute("countryDto", countryDto);
		return "/WEB-INF/views/country/detail.jsp";
	}
	
	//삭제 매핑
	@RequestMapping("/delete")
	public String delete(@RequestParam int countryNo) {
		CountryDto countryDto = countryDao.selectOne(countryNo);
		if(countryDto == null) throw new TargetNotfoundException("존재하지 않는 국가");
		
		countryDao.delete(countryNo);
		return "redirect:./list";//상대경로
//		return "redirect:country/list"; //절대경로
	}
	
	//수정 매핑
	@GetMapping("/edit")
	public String edit(@RequestParam int countryNo, Model model) {
		CountryDto countryDto = countryDao.selectOne(countryNo);
		if(countryDto == null) throw new TargetNotfoundException("존재하지 않는 국가");
		
		model.addAttribute("countryDto", countryDto);
		return "/WEB-INF/views/country/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute CountryDto countryDto) {
		countryDao.update(countryDto); //오류 검사는 get에서 이미 진행했기 때문에 굳이 중복해서 하지 않음
		return "redirect:./detail?countryNo=" + countryDto.getCountryNo();
	}
}
