package com.kh.spring09.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.BookDto;
import com.kh.spring09.mapper.BookMapper;
import com.kh.spring09.vo.PageVo;

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
	public List<BookDto> selectList(int beginRownum, int endRownum){
		String sql = "select * from("
					+ "select rownum rn, TMP.* from("
						+ "select * from book order by book_id asc"
						+ ") TMP"
						+ ") where rn between ? and ?";
		Object[] params = {beginRownum, endRownum};
		return jdbcTemplate.query(sql, bookMapper, params);
	}
	
	//검색
	public List<BookDto> selectList(PageVo pageVo){
		if(pageVo.isList()) return selectList(pageVo.getBeginRownum(), pageVo.getEndRownum());
		if(!allowColumns.contains(pageVo.getColumn())) return List.of();
		
		String sql = "select * from ("
				+ "select rownum rn, TMP.* from ("
				+ "select * from book "
				+ "where instr("+pageVo.getColumn()+", ?) > 0 "
				+ "order by book_id asc"
				+ ") TMP"
				+ ") where rn between ? and ?";
		Object[] params = {
					pageVo.getKeyword(), pageVo.getBeginRownum(), 
					pageVo.getEndRownum()
				};
		return jdbcTemplate.query(sql, bookMapper, params);
	}
	
	//상세조회
	public BookDto selectOne(int bookId) {
		String sql = "select * from book where book_id=?";
		Object[] params = {bookId};
		List<BookDto> list = jdbcTemplate.query(sql, bookMapper, params);
		return list.isEmpty() ? null : list.get(0);
	}
	
	//카운트 메소드
	public int count() {
		String sql = "select count(*) from book";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	public int count(PageVo pageVo) {
		if(pageVo.isList()) return count();
		
		if(allowColumns.contains(pageVo.getColumn()) == false)
			return count();
		
		String sql = "select count(*) from book where instr("+pageVo.getColumn()+", ?) > 0";
		Object[] params = {pageVo.getKeyword()};
		return jdbcTemplate.queryForObject(sql, int.class, params);
	}
}
