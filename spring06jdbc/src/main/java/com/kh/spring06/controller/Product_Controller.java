package com.kh.spring06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06.dao.ProductDao;
import com.kh.spring06.dto.ProductDto;

@RestController
@RequestMapping("/product")
public class Product_Controller {
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute ProductDto productDto) {
		productDao.insert(productDto);
		return "강좌 정보 등록이 완료되었습니다.";
	}

}
