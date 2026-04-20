package com.kh.spring09.dao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.mapper.BoardMapper;

@Repository
public class BoardDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BoardMapper boardMapper;
	Set<String> allowColumns = Set.of(
			"board_title", "board_writer");
	
	//시퀀스 번호 불러오기
	public int sequence() {
	    String sql = "select board_seq.nextval from dual";
	    return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	//등록
	public void write(BoardDto boardDto) {
		String sql = "insert into board("
				+ "board_no, "
				+ "board_head, "
				+ "board_title, "
				+ "board_content, "
				+ "board_writer) "
				+ "values(board_seq.nextval, ?, ?, ?, ?)";
		Object[] params = {
				boardDto.getBoardHead(), boardDto.getBoardTitle(), boardDto.getBoardContent(),
				boardDto.getBoardWriter()
		};
		jdbcTemplate.update(sql, params);
	}
	
	//작성자와 아이디가 같음을 조회
		public BoardDto checkId(String memberId) {
			String sql ="select * from member M"
					+ "Inner Join board B ON M.member_id = B.board_writer"
					+ "where M.member_id = ?";
			Object[] params = {memberId};
			List<BoardDto> list = jdbcTemplate.query(sql, boardMapper, params);
			return list.isEmpty() ? null : list.get(0);
		}
	
	//목록(일반)
	public List<BoardDto> selectList(){
		String sql = "select * from board order by board_no desc";
		List<BoardDto> list = jdbcTemplate.query(sql, boardMapper);
		return list;
	}
	
	
	//검색
	public List<BoardDto> selectList(String column, String keyword){
		if(column == null || keyword == null) return selectList();
		if(column.isBlank() || keyword.isBlank()) return List.of();
		if(allowColumns.contains(column) == false) return List.of();
		
		String sql = "select * from board where instr("+column+", ?) > 0 order by board_no asc";
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, boardMapper, params);
	}
	
	//상세
	public BoardDto selectOne(int boardNo) {
		String sql = "select * from board where board_no=?";
		Object[] params = {boardNo};
		List<BoardDto> list = jdbcTemplate.query(sql, boardMapper, params);
		return list.isEmpty() ? null : list.get(0);
	}
	
	//수정
	public boolean edit(BoardDto boardDto) {
		String sql = "update board set "
				+ "board_head=?, "
				+ "board_title=?, "
				+ "board_content=?, board_etime=systimestamp "
				+ "where board_no=?";
		Object[] params = {
				boardDto.getBoardHead(), boardDto.getBoardTitle(), 
				boardDto.getBoardContent(), boardDto.getBoardNo()
		};
		return jdbcTemplate.update(sql, params) > 0;
	}
	
	//조회수 증가 수정
	public boolean editReadcount(int boardNo) {
		String sql ="update board set board_readcount= board_readcount+1 where board_no=?";
		Object[] params = {boardNo};
		return jdbcTemplate.update(sql, params) > 0;
	}
	
	
	
	//삭제
	public boolean delete(int boardNo) {
		String sql = "delete board where board_no=?";
		Object[] params = {boardNo};
		return jdbcTemplate.update(sql, params) > 0;
	}
}
