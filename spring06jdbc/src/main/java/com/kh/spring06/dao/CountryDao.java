package com.kh.spring06.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring06.dto.CountryDto;
import com.kh.spring06.mapper.CountryMapper;

@Repository // DB나 파일을 제어하기 위한 도구 (영속성을 가진 대상 제어 도구)
public class CountryDao {
	//주세요! // 단, 등록이 되어 있어야함
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	@Autowired
	private CountryMapper countryMapper;
	
	//필요한 기능 등록
	//등록
	public void insert(CountryDto countryDto) {
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
	}
}
