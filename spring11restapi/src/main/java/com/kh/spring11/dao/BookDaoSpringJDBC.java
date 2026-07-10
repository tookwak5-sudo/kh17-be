package com.kh.spring11.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring11.dto.BookDto;
import com.kh.spring11.mapper.BookMapper;
import com.kh.spring11.vo.ListRequestVO;
import com.kh.spring11.vo.PageVo;

@Repository
public class BookDaoSpringJDBC implements BookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BookMapper bookMapper;
	
	//내가 만드는건 Autowired를 쓰면 안된다
	private Set<String> allowColumns = Set.of(
			"book_title", "book_author", "book_publication_date"
	);
			
	//등록
	public int sequence() {
		String sql = "select book_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	public void insert(BookDto bookDto) {
		String sql = "insert into book("
				+ "book_id, book_title, book_author, "
				+ "book_publication_date, book_price, "
				+ "book_publisher, book_page_count, book_genre)"
				+ " values(?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {
				bookDto.getBookId(),
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
	
	//상세조회
	public BookDto selectOne(int bookId) {
		String sql = "select * from book where book_id=?";
		Object[] params = {bookId};
		List<BookDto> list = jdbcTemplate.query(sql, bookMapper, params);
		return list.isEmpty() ? null : list.get(0);
	}
		
	//더보기 형식의 목록
	public List<BookDto> selectList(int lastBookId, int size){
		if(lastBookId ==0 ) {
			lastBookId = Integer.MAX_VALUE;
		}
		String sql = "select * from ("
					+ "select rownum rn, TMP.* from ("
						+ "select * from book "
						+ "where book_id < ? "
						+ "order by book_id desc"
					+ ")TMP"
				+ ") where rn between 1 and ?";
		Object[] params = { lastBookId, size };
		return jdbcTemplate.query(sql, bookMapper, params);
	}
	public List<BookDto> selectList(ListRequestVO vo){
		return selectList(vo.getLastNo(), vo.getSize());
	}
	
	public int count(int lastBookId) {
		if(lastBookId ==0 ) {
			lastBookId = Integer.MAX_VALUE;
		}
		String sql = "select count(*) from book where book_id < ?";
		Object[] params = { lastBookId };
		return jdbcTemplate.queryForObject(sql, int.class, params);
	}
	public int count(ListRequestVO vo) {
		return count(vo.getLastNo());
	}
}
