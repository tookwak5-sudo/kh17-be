package com.kh.spring10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dao.BookDao;
import com.kh.spring10.dto.BookDto;

@CrossOrigin
@RestController
@RequestMapping("/api/book")
public class BookRestController {
	@Autowired
	private BookDao bookDao;
	
	@PostMapping("/insert")
	public void insert(@RequestBody BookDto bookDto) {
		int bookId = bookDao.sequence();
		bookDto.setBookId(bookId);
		bookDao.insert(bookDto);
	}
}
