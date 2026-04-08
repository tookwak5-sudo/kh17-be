package com.kh.spring06.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring06.dto.BookDto;
import com.kh.spring06.mapper.BookMapper;

@Repository
public class BookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BookMapper bookMapper;
	
	//내가 만드는건 Autowired를 쓰면 안된다
	private Set<String> allowColumns = Set.of(
			"book_title", "book_author", "book_publication_date"
	);
			
	
	//등록
	public void insert(BookDto bookDto) {
		String sql = "insert into book("
				+ "book_id, book_title, book_author, "
				+ "book_publication_date, book_price, "
				+ "book_publisher, book_page_count, book_genre)"
				+ " values(book_seq.nextVal, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {
				bookDto.getBookTitle(), bookDto.getBookAuthor(), bookDto.getBookPublicationDate(),
				bookDto.getBookPrice(), bookDto.getBookPublisher(), bookDto.getBookPageCount(),
				bookDto.getBookGenre()
		};
		jdbcTemplate.update(sql, params);
	}
	
	//수정
	public boolean update(BookDto bookDto) {
		String sql = "update book set "
				+ "book_title=?, "
				+ "book_author=?, "
				+ "book_publication_date=?, "
				+ "book_price =?, "
				+ "book_publisher =?, "
				+ "book_page_count =?, "
				+ "book_genre= ? "
				+ "where book_id =?";
		Object[] params = { // 데이터도 꼭 순서대로 쓰기
				bookDto.getBookTitle(), bookDto.getBookAuthor(), bookDto.getBookPublicationDate(), bookDto.getBookPrice(),
				bookDto.getBookPublisher(), bookDto.getBookPageCount(), bookDto.getBookGenre(), bookDto.getBookId()
		};
		return jdbcTemplate.update(sql, params) > 0;
	}
	
	// 삭제
	public boolean delete(int bookId) {
		String sql = "delete book where book_id =? ";
		Object[] params = {bookId};
		return jdbcTemplate.update(sql, params) > 0;
	}
	
	//조회
	public List<BookDto> selectList(){
		String sql = "select * from book order by book_id asc";
		return jdbcTemplate.query(sql, bookMapper);
	}
	
	//검색
	public List<BookDto> selectList(String column, String keyword){
		if(column == null || keyword == null) return selectList();
		if(column.isBlank() || keyword.isBlank()) return selectList();
		if(!allowColumns.contains(column)) return List.of();
		
		String sql = "select * from book where instr("+column+", ?) > 0 order by book_id asc";
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, bookMapper, params);
	}
	
	//상세조회
	public BookDto selectOne(int bookId) {
		String sql = "select * from book where book_id=?";
		Object[] params = {bookId};
		List<BookDto> list = jdbcTemplate.query(sql, bookMapper, params);
		return list.isEmpty() ? null : list.get(0);
	}
}
