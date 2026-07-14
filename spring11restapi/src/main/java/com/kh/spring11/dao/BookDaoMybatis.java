package com.kh.spring11.dao;

import java.util.List;

import com.kh.spring11.dto.BookDto;

public class BookDaoMybatis implements BookDao {

	@Override
	public int sequence() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insert(BookDto bookDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update(BookDto bookDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int bookId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BookDto selectOne(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDto> selectList(int lastBookId, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(int lastBookId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
