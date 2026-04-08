package com.kh.spring09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring09.dao.BookDao;
import com.kh.spring09.dto.BookDto;

@Controller
@RequestMapping("/book") //무조거 RequestMapping만 가능(GET/POST 선택불가);
public class BookController {
	@Autowired // 의존성 주입 Dependency injection
	private BookDao bookDao;
	
	@GetMapping("/insert")
	public String insert() {
		return "/WEB-INF/views/book/insert.jsp";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute BookDto bookDto) {
		bookDao.insert(bookDto);
		return "redirect:/book/insertComplete";
//		return "redirect:./insertComplete";
	}
	
	@RequestMapping("/insertComplete")
	public String insertComplete() {
		return "/WEB-INF/views/book/insertComplete.jsp";
	}
	
}
