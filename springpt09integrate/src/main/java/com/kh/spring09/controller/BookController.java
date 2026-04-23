package com.kh.spring09.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring09.dao.BookDao;
import com.kh.spring09.dto.BookDto;
import com.kh.spring09.exception.GetOutException;
import com.kh.spring09.exception.TargetNotfoundException;
import com.kh.spring09.service.AttachService;
import com.kh.spring09.vo.PageVo;

@Controller
@RequestMapping("/book") //무조거 RequestMapping만 가능(GET/POST 선택불가);
public class BookController {
	@Autowired // 의존성 주입 Dependency injection
	private BookDao bookDao;
	
	@Autowired
	private AttachService attachService;
	
	@GetMapping("/insert")
	public String insert() {
		return "book/insert";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute BookDto bookDto,
						@RequestParam MultipartFile attach) throws IOException, Exception {
		
		//if(attach.isEmpty()) throw new GetOutException();
		
		//번호 생성 후 도서 등록하도록 처리
		int bookId = bookDao.sequence();
		bookDto.setBookId(bookId);
		bookDao.insert(bookDto); // 도서저장
		
		if(!attach.isEmpty()) { //책표지가 있을 경우엔
			int attachNo = attachService.save(attach); //파일저장
			bookDao.connect(bookId, attachNo); //연결
		}
		
		return "redirect:/book/insertComplete";
//		return "redirect:./insertComplete";
	}
	
	@RequestMapping("/insertComplete")
	public String insertComplete() {
		return "book/insertComplete";
	}
	
	@RequestMapping("/list")
	public String list(@ModelAttribute PageVo pageVo ,Model model) {
		List<BookDto> list = bookDao.selectList(pageVo);
		model.addAttribute("list", list);
		
		int count = bookDao.count(pageVo);
		pageVo.setCount(count);
		model.addAttribute("pageVo", pageVo);
		
		return "book/list";
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
//		return "book/list";
//		
//	}
	
	@RequestMapping("/detail")
	public String detail(Model model, @RequestParam int bookId) {
		BookDto bookDto = bookDao.selectOne(bookId);
		if(bookDto == null) throw new TargetNotfoundException("존재하지 않는 도서입니다");
		model.addAttribute("bookDto",bookDto);
		return "book/detail";
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
		return "book/edit";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute BookDto bookDto) {
		bookDao.update(bookDto);
		return "redirect:./detail?bookId=" + bookDto.getBookId();
	}
	
	//도서 표지를 반환하는 매핑
	@RequestMapping("/cover")
	public String cover(@RequestParam int bookId) {
		try {
			int attachNo = bookDao.searchCover(bookId);
			return "redirect:/download/legacy?attachNo="+attachNo;
		}
		catch(Exception e) {
			return "redirect:/images/no_image.png";
		}
	}
	
}
