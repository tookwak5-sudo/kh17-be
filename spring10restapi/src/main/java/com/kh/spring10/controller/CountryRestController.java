package com.kh.spring10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dao.CountryDao;
import com.kh.spring10.dto.CountryDto;
import com.kh.spring10.vo.ListVO;

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
	
	@GetMapping("/listForReact")
	public ListVO listForReact(
	   @RequestParam(required = false, defaultValue = "0") int lastCountryNo,
	   @RequestParam(required = false, defaultValue = "10") int size
	){
		List list = countryDao.selectListForReact(lastCountryNo, size);
		int count = countryDao.countForReact(lastCountryNo);
		
		return ListVO.builder()
						.list(list)
						.last(count <= size) //보기로 한 개수보다 데이터가 같거나 적으면 마지막
					.build();
	}
	
}
