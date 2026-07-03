package com.kh.spring10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dao.CountryDao;
import com.kh.spring10.dto.CountryDto;

@CrossOrigin
@RestController
@RequestMapping("/api/country")
public class CountryRestController {
	@Autowired
	private CountryDao countryDao;
	
	@GetMapping("/list")
	public List<CountryDto> list() {
		return countryDao.selectList(1, 10000);
	}
	
}
