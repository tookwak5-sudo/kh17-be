package com.kh.spring11.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring11.dto.BookDto;

@Component
public class BookMapper implements RowMapper<BookDto>{

	@Override
	public BookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		BookDto bookDto = new BookDto();
		bookDto.setBookId(rs.getInt("book_id"));
		bookDto.setBookTitle(rs.getString("book_title"));
		bookDto.setBookAuthor(rs.getString("book_author"));
		bookDto.setBookPublicationDate(rs.getString("book_publication_date"));
		bookDto.setBookPrice(rs.getObject("book_price", Integer.class));
		bookDto.setBookPublisher(rs.getString("book_publisher"));
		bookDto.setBookPageCount(rs.getObject("book_page_count", Integer.class));
		bookDto.setBookGenre(rs.getString("book_genre"));
		return bookDto;
	}
}
