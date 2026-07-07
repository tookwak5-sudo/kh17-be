package com.kh.spring10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dao.BookDao;
import com.kh.spring10.dao.LectureDao;
import com.kh.spring10.dto.BookDto;
import com.kh.spring10.vo.ListVO;

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
	
	//목록
	@GetMapping("/list")
	public List<BookDto> list(){
		return bookDao.selectList(1, 10000);
	}
	
	@GetMapping("/listForReact")
	public ListVO listForReact(
		@RequestParam(required = false, defaultValue = "0") int lastBookId,
		@RequestParam(required = false, defaultValue = "10") int size
	) {
		//내림차순 정렬이기 때문에 0이면 0보다 작다가 되어서 문제가 되므로 변경
		if(lastBookId == 0) {
			lastBookId = Integer.MAX_VALUE;
		}
		List list = bookDao.selectListForReact(lastBookId, size);
		int count = bookDao.countForReact(lastBookId);
		
		return ListVO.builder()
						.list(list)
						.last(count <= size) //보기로 한 개수보다 데이터가 같거나 적으면 마지막
					.build();
	}
	
	
}
