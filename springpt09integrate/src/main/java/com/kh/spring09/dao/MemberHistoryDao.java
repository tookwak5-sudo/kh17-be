package com.kh.spring09.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.MemberHistoryDto;

@Repository
public class MemberHistoryDao {
	@Autowired
	private	JdbcTemplate jdbcTemplate;
//	@Autowired
//	private MemberHistoryDto memberHistoryDto = new MemberHistoryDto();
//	
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
}
