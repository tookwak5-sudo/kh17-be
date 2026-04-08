package com.kh.spring06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//country 삭제를 위한 페이지
	@RequestMapping("/delete")   //http://localhost:8080/country/delete 마지막 '/(슬래쉬)'를 endPoint라고함 
	public String delete(@RequestParam int countryNo) {
		boolean success = countryDao.delete(countryNo);
		
		if(success) {
			return "국가 정보 삭제가 완료되었습니다.";
		}
		else {
			return "존재하지 않는 국가입니다.";
		}
	}
	
	//country 조회 매핑
	//1. 목록 및 검색 (column, keyword 파라미터가 선택적으로 존재)
	//2. 상세조회(기본키, primary key)
	
	//1
	@RequestMapping("/list")
	public String list(
			@RequestParam(required = false) String column, 
			@RequestParam(required = false) String keyword) {
		//검색어가 있든 없든 상관없이 검색을 수정(내부적으로 구분하여 처리함)
		List<CountryDto> list = countryDao.selectList(column, keyword);
//		return list.toString();
		
		//StringBuffer를 이용해서 문자열로 만들어서 반환(나중에 화면으로 바뀜)
		StringBuffer buffer = new StringBuffer();
		buffer.append("결과 수 : " + list.size());
		buffer.append("<br>");
		for(CountryDto countryDto : list) {
			buffer.append(countryDto);
			buffer.append("<br>");	
		}
		return buffer.toString();
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int countryNo) {
		CountryDto countryDto = countryDao.selectOne(countryNo); //조회
		
		if(countryDto == null) {
			return "존재하지 않는 국가 정보";
		}
		else {
			StringBuffer buffer = new StringBuffer();
			buffer.append("번호 : " + countryDto.getCountryNo() + "<br>");
			buffer.append("대륙 : " + countryDto.getCountryRegion() + "<br>");
			buffer.append("이름 : " + countryDto.getCountryName() + "<br>");
			buffer.append("수도 : " + countryDto.getCountryCapital() + "<br>");
			buffer.append("인구 : " + countryDto.getCountryPopulation() + "<br>");
			return buffer.toString();
		}
	}
}

