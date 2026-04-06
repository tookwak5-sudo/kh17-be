package com.kh.spring06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06.dto.CountryDto;

@RestController // 등록
public class CountryController {
	@Autowired // 주세요! (의존성 주입, DI, Dependency Injection)
	private JdbcTemplate jdbcTemplate;
	
	//country등록을 위한 page를 만들어보자!
	@RequestMapping("/insert")
	public String insert(@ModelAttribute CountryDto countryDto) {
		String sql = "insert into country("
				+ "country_no, country_region, country_name, "
				+ "country_capital, country_population"
				+ ") "
				+ "values("
				+ "country_seq.nextVal, ?, ?, ?, ?"
				+ ")";
		Object[] params = {
				countryDto.getCountryRegion(), countryDto.getCountryName(), 
				countryDto.getCountryCapital(), countryDto.getCountryPopulation()
				};
		
		jdbcTemplate.update(sql, params);
		
		return "국가 정보 등록이 완료되었습니다.";
	}
}
