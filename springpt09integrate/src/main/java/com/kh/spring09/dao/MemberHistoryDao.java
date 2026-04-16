package com.kh.spring09.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.dto.MemberHistoryDto;
import com.kh.spring09.mapper.MemberHistoryMapper;

@Repository
public class MemberHistoryDao {
	@Autowired
	private	JdbcTemplate jdbcTemplate;
	@Autowired
	private MemberHistoryMapper memberHistoryMapper;
	Set<String> allowColumns = Set.of(
			"member_id", "member_nickname", "member_contact", "member_level");
	
	
	//등록
	public void insert(MemberHistoryDto memberHistoryDto) {
		String sql = "insert into member_history("
				+ "member_history_no, member_history_origin, "
				+ "member_history_address, member_history_agent) "
				+ "values(member_history_seq.nextval, ?, ?, ?)";
		Object[] params = {
				memberHistoryDto.getMemberHistoryOrigin(),
				memberHistoryDto.getMemberHistoryAddress(), 
				memberHistoryDto.getMemberHistoryAgent()
		};
		jdbcTemplate.update(sql, params);
	}
	
	//조회(Top N + 아이디)
	public List<MemberHistoryDto> selectList(String memberHistoryOrigin, int beginRow, int endRow){
		String sql = "select * from ("
						+ "select rownum RN, TMP.* from ("
							+ "select * from member_history "
							+ "where member_history_origin= ? "
							+ "order by member_history_time desc, member_history_no desc"
						+ ") TMP"
					+ ") where RN between ? and ?";
		Object[] params = {memberHistoryOrigin, beginRow, endRow};
		return jdbcTemplate.query(sql, memberHistoryMapper,params);
	}
	
	// 검색(날짜 기간 + Top N + 아이디)
	public List<MemberHistoryDto> selectList(
	        String memberHistoryOrigin, String beginDate, String endDate, int beginRow, int endRow) {
	    
		//날짜가 없다면 검색결과를 보여주지 마세요!!!!
		if(beginDate == null || endDate == null) return List.of();
		
	    String sql = "select * from ("
	                    + "select rownum RN, TMP.* from ("
	                        + "select * from member_history "
	                        + "where member_history_origin = ? "
	                        + "AND "
	                        + "("
	                        + "member_history_time between to_timestamp(? || ' ' || '00:00:00.000', 'YYYY-MM-DD HH24:MI:SS.FF3')"
	                        + "and "
	                        + "to_timestamp(? || ' ' || '00:00:00.000', 'YYYY-MM-DD HH24:MI:SS.FF3'))"
	                        + "order by member_history_time desc, member_history_no desc"
	                    + ") TMP"
	                + ") where RN between ? and ?";
	    
	    // 파라미터 순서: 아이디 -> 시작일 -> 종료일 -> 시작행 -> 종료행
	    Object[] params = {memberHistoryOrigin, beginDate, endDate, beginRow, endRow};
	    return jdbcTemplate.query(sql, memberHistoryMapper, params);
	}
	//아이디조회
			public MemberHistoryDto selectOne(String memberId) {
			    String sql = "select * from member where member_id = ?";
			    Object[] params = {memberId};
			    List<MemberHistoryDto> list = jdbcTemplate.query(sql, memberHistoryMapper, params);
			    return list.isEmpty() ? null : list.get(0);
			}
	//조회
		public List<MemberHistoryDto> selectList(){
			String sql = "select * from member order by member_id asc";
			return jdbcTemplate.query(sql, memberHistoryMapper);
		}
		
		//검색
		public List<MemberHistoryDto> selectList(String column, String keyword){
			if(column == null || keyword == null) return selectList();
			if(column.isBlank() || keyword.isBlank()) return selectList();
			if(allowColumns.contains(column) == false) return List.of();
			
			String sql = "select * from member where instr("+ column +", ?) > 0 order by member_id asc";
			Object[] params = { keyword };
			return jdbcTemplate.query(sql, memberHistoryMapper, params);
		}
}