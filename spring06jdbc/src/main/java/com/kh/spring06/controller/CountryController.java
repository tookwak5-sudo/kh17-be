package com.kh.spring06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06.dao.CountryDao;
import com.kh.spring06.dto.CountryDto;

@RestController // 등록
@RequestMapping("/country") // 공용주소
public class CountryController {
// jdbcTemplate에서 다이렉트 연결
	//	@Autowired // 주세요! (의존성 주입, DI, Dependency Injection)
//	private JdbcTemplate jdbcTemplate;

	@Autowired // 주세요
	private CountryDao countryDao;
	
	//country등록을 위한 page를 만들어보자!
	@RequestMapping("/insert") // 개별주소
	public String insert(@ModelAttribute CountryDto countryDto) {
		countryDao.insert(countryDto);
		return "국가 정보 등록이 완료되었습니다.";
	}
	
	//country 수정을 위한 페이지
	//일반적인 흐름 : 수정정보입력 -> 수정처리 -> 성공/실패 안내
	@RequestMapping("/update")
	public String update(@ModelAttribute CountryDto countryDto) {
		boolean success = countryDao.update(countryDto);
		if(success) {
			return "국가 정보 변경이 완료되었습니다.";
		}
		else {
			return "존재하지 않는 국가입니다.";
		}
	}
}
