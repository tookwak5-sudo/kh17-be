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
	
	//검색 허용할 컬럼
	Set<String> allowColumns = Set.of(
			"board_title", "board_writer");
	
	
	
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
		String sql = "select * from board_list order by board_no desc"; //wtime으로 해도 되나 기본키가 가장 빠르기 때문에 기본키로 순서 지정
		List<BoardDto> list = jdbcTemplate.query(sql, boardMapper);
		return list;
	}
	
	//검색
	public List<BoardDto> selectList(String column, String keyword){
		if(column == null || keyword == null) return selectList();
		if(column.isBlank() || keyword.isBlank()) return List.of();
		if(!allowColumns.contains(column)) return selectList();
		
		String sql = "select * from board_list where instr("+column+", ?) > 0 order by board_no desc";
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, boardMapper, params);
	}
	
	//상세
	public BoardDto selectOne(long boardNo) { //상세에서는 내용이 있어야함(board_list라 쓰면 안됨)
		String sql = "select * from board where board_no=?";
		Object[] params = {boardNo};
		List<BoardDto> list = jdbcTemplate.query(sql, boardMapper, params);
		return list.isEmpty() ? null : list.get(0); 
		//list.getFirst() // list.get(0)은 범용적, list.getFirst()는 신버전
	}
	
	//[변형] 이전 글 정보
	public BoardDto selectPreviousOne(long boardNo) {
		String sql = "select * from board_list where board_no = ("
				+ "	select max(board_no) from board where board_no < ?"
				+ ")";
		Object[] params = {boardNo};
		List<BoardDto> list = jdbcTemplate.query(sql, boardMapper, params);
		return list.isEmpty() ? null : list.get(0); 
		//list.getFirst() // list.get(0)은 범용적, list.getFirst()는 신버전
	}
	
	//[변형] 다음 글 정보
	public BoardDto selectNextOne(long boardNo) {
		String sql = "select * from board_list where board_no = ("
				+ "	select min(board_no) from board where board_no > ?"
				+ ")";
		Object[] params = {boardNo};
		List<BoardDto> list = jdbcTemplate.query(sql, boardMapper, params);
		return list.isEmpty() ? null : list.get(0); 
		//list.getFirst() // list.get(0)은 범용적, list.getFirst()는 신버전
	}
	
		//우리 등록이 달라졌어요
		//(기존) 시퀀스 번호를 생성하면서 등록
		//(변경) 시퀀스 번호 생성 먼저하고 등록을 나중에 → 자바가 등록될 대상의 기본키를 알 수 있도록
		//시퀀스 번호 불러오기
		public long sequence() {
		    String sql = "select board_seq.nextval from dual";
		    //return jdbcTemplate.query(sql, boardMapper); //board테이블을 조회했을 때
		    // long이라는 알려져있는 형태, 1가지 값만 나올 경우
		    return jdbcTemplate.queryForObject(sql, long.class); //정해진 형태(null 불가)
		    //return jdbcTemplate.queryForObject(sql, Long.class); //정해진 형태(null 허용)
		}	

		//등록 이제부터는 번호가 홀더
		public void insert(BoardDto boardDto) {
			String sql = "insert into board("
				+ "board_no, "
				+ "board_head, "
				+ "board_title, "
				+ "board_content, "
				+ "board_writer) "
				+ "values(?, ?, ?, ?, ?)";
			Object[] params = {
				boardDto.getBoardNo(), boardDto.getBoardHead(), 
				boardDto.getBoardTitle(), boardDto.getBoardContent(), 
				boardDto.getBoardWriter()
			};
			jdbcTemplate.update(sql, params);
		}
		
	//삭제 //interceptor에서 범위를 제한시켜서 삭제 권한 제한
	public boolean delete(long boardNo) {
		String sql = "delete board where board_no=?";
		Object[] params = {boardNo};
		return jdbcTemplate.update(sql, params) > 0;
	}
		
	//수정
	public boolean update(BoardDto boardDto) {
		String sql = "update board set "
				+ "board_head=?, "
				+ "board_title=?, "
				+ "board_content=?, "
				+ "board_etime=systimestamp "
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
		
	
	
	
	
}
