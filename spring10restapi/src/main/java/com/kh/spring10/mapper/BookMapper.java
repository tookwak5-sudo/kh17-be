package com.kh.spring10.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring10.dto.BookDto;

@Component
public class BookMapper implements RowMapper<BookDto>{

	@Override
	public BookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		BookDto bookDto = new BookDto();
		bookDto.setBookId(rs.getInt("book_id"));
		bookDto.setBookTitle(rs.getString("book_title"));
		bookDto.setBookAuthor(rs.getString("book_author"));
		bookDto.setBookPublicationDate(rs.getString("book_publication_date"));
		bookDto.setBookPrice(rs.getLong("book_price"));
		bookDto.setBookPublisher(rs.getString("book_publisher"));
		bookDto.setBookPageCount(rs.getInt("book_page_count"));
		bookDto.setBookGenre(rs.getString("book_genre"));
		return bookDto;
	}
}
