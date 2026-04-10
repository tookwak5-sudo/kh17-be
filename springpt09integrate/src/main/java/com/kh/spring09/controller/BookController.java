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

import com.kh.spring09.dao.BookDao;
import com.kh.spring09.dto.BookDto;
import com.kh.spring09.exception.TargetNotfoundException;

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
	
	@RequestMapping("/list")
	public String list(Model model, 
						@RequestParam(required = false) String column,
						@RequestParam(required = false) String keyword) {
		List<BookDto> list = bookDao.selectList(column, keyword);
		model.addAttribute("list", list);
		return "/WEB-INF/views/book/list.jsp";
	}
	
//	@RequestMapping("/list")
//	public String list(Model model, 
//			@RequestParam(required = false) String keyword) {
//		if(keyword != null) {
//			List<BookDto> listByBookTitle = bookDao.selectList("book_title", keyword);
//			List<BookDto> listByBookAuthor = bookDao.selectList("book_author", keyword);
//			List<BookDto> listByBookPublicationDate = bookDao.selectList("book_publication_date", keyword);
//			model.addAttribute("listByBookTitle", listByBookTitle);
//			model.addAttribute("listByBookAuthor", listByBookAuthor);
//			model.addAttribute("listByBookPublicationDate", listByBookPublicationDate);
//		}
//		return "/WEB-INF/views/book/list.jsp";
//		
//	}
	
	@RequestMapping("/detail")
	public String detail(Model model, @RequestParam int bookId) {
		BookDto bookDto = bookDao.selectOne(bookId);
		if(bookDto == null) throw new TargetNotfoundException("존재하지 않는 도서입니다");
		model.addAttribute("bookDto",bookDto);
		return "/WEB-INF/views/book/detail.jsp";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int bookId) {
		BookDto bookDto = bookDao.selectOne(bookId);
		if(bookDto == null) throw new TargetNotfoundException("존재하지 않는 도서입니다");
		bookDao.delete(bookId);
		return "redirect:./list";
//		return "redirect:book/list";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam int bookId, Model model) {
		BookDto bookDto = bookDao.selectOne(bookId);
		if(bookDto == null) throw new TargetNotfoundException("존재하지 않는 도서입니다");
		
		model.addAttribute("bookDto", bookDto);
		return "/WEB-INF/views/book/edit.jsp";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute BookDto bookDto) {
		bookDao.update(bookDto);
		return "redirect:./detail?bookId=" + bookDto.getBookId();
	}
	
}
