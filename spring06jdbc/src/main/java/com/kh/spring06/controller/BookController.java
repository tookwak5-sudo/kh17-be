package com.kh.spring06.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06.dao.BookDao;
import com.kh.spring06.dto.BookDto;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookDao bookDao;
	
	
	
	//등록
	@RequestMapping("/insert")
	public String insert(@ModelAttribute BookDto bookDto) {
		bookDao.insert(bookDto);
		return "도서 정보 등록 완료";
	}
	
	//수정
	@RequestMapping("/update")
	public String update(@ModelAttribute BookDto bookDto,
				HttpServletResponse response) throws IOException {
		boolean success = bookDao.update(bookDto);
		if(!success) {
			response.sendRedirect("notFound");
			return null;
		}
		return "도서 정보 변경 완료";
	}
	
	//삭제
	@RequestMapping("/delete")
	public String delete(@RequestParam int bookId, 
									HttpServletResponse response) throws IOException {
		boolean success = bookDao.delete(bookId);
		if(!success) {
			response.sendRedirect("./notFound");  // ./ 현재위치, ../상위위치
			return null;
		}
		return "도서 정보가 삭제되었습니다.";
	}
	
	//조회
	@RequestMapping("/list")
	public String list(
			@RequestParam(required = false) String column, 
			@RequestParam(required = false) String keyword) {
		List<BookDto> list = bookDao.selectList(column, keyword);
	//여기까지 DB조회
	//아래부턴 꾸며주기 나중엔 화면@Controller에서 처리할 예정
		StringBuffer buffer = new StringBuffer();
		buffer.append("총 도서 보유량 : " + list.size() + "권");
		buffer.append("<br>");
		for(BookDto bookDto : list) {
			buffer.append(bookDto).append("<br>");
		}
		return buffer.toString();
	}
	
	//상세조회
	@RequestMapping("/detail")
	public String detail(@RequestParam int bookId,
					HttpServletResponse response) throws IOException {
		BookDto bookDto = bookDao.selectOne(bookId);
		
		
		if(bookDto == null) {
			response.sendRedirect("./notFound");
			return null;
		}
		
		//일반적 상황
		StringBuffer buffer = new StringBuffer();
		buffer.append(" [" + bookDto.getBookTitle() + "] ");
		buffer.append("지은이 : " + bookDto.getBookAuthorString() + "] ");
		buffer.append("출판사 : " + bookDto.getBookPublisherString() + "] ");
		return buffer.toString();
	}
	
	//오류 메세지 매핑
		@RequestMapping("/notFound") // 404
		public String notFound() {
			return "존재하지 않는 도서 정보 입니다.";
		}
	
	
}
