package com.kh.spring11.dao;

import java.util.List;

import com.kh.spring11.dto.BookDto;

public interface BookDao {
	int sequence(); //등록
	void insert(BookDto bookDto);
	boolean update(BookDto bookDto); //수정
	boolean delete(int bookId); //삭제
	BookDto selectOne(int bookId); //상세
	List<BookDto> selectList(int lastBookId, int size); //목록(더보기)
	int count(int lastBookId); //개수
}
