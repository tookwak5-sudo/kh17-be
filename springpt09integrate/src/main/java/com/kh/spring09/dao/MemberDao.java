package com.kh.spring09.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.mapper.MemberMapper;

@Repository
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private MemberMapper memberMapper;
	Set<String> allowColumns = Set.of(
			"memberId", "memberNickname", "memberContact", "memberLevel");
	
	//등록
	public void insert(MemberDto memberDto) {
		String sql = "insert into member("
				+ "member_no, member_id, member_email, "
				+ "member_password, member_nickname, member_birth, "
				+ "member_contact, member_post, member_address1, "
				+ "member_address2, member_level, member_message, member_join, member_change, member_point) "
				+ "values(member_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {
				memberDto.getMemberId(), memberDto.getMemberEmail(),
				memberDto.getMemberPassword(), memberDto.getMemberNickname(), memberDto.getMemberBirth(),
				memberDto.getMemberContact(), memberDto.getMemberPost(), memberDto.getMemberAddress1(),
				memberDto.getMemberAddress2(),memberDto.getMemberLevel(), memberDto.getMemberMessage(),
				memberDto.getMemberJoin(), memberDto.getMemberChange(), memberDto.getMemberPoint()
		};
		jdbcTemplate.update(sql, params);
	}
	
	//수정
	public boolean update(MemberDto memberDto) {
		String sql = "update member set "
				+ "member_id=?, "
				+ "member_email=?, "
				+ "member_password=?, "
				+ "member_nickname=?, "
				+ "member_birth=?, "
				+ "member_contact=?, "
				+ "member_post=?, "
				+ "member_address1=?, "
				+ "member_address2=?, "
				+ "member_message=? "
				+ "where member_no= ?";
		Object[] params = {
				memberDto.getMemberId(), memberDto.getMemberEmail(),
				memberDto.getMemberPassword(), memberDto.getMemberNickname(), memberDto.getMemberBirth(),
				memberDto.getMemberContact(), memberDto.getMemberPost(), memberDto.getMemberAddress1(),
				memberDto.getMemberAddress2(), memberDto.getMemberMessage(), memberDto.getMemberNo()
		};
		return jdbcTemplate.update(sql, params) > 0;
	}
	
	//삭제
	public boolean delete(long memberNo) {
		String sql = "delete member where member_no =?";
		Object[] params = {memberNo};
		return jdbcTemplate.update(sql, params) > 0;
	}
	
	//조회
	public List<MemberDto> selectList(){
		String sql = "select * from member order by member_no asc";
		return jdbcTemplate.query(sql, memberMapper);
	}
	
	//검색
	public List<MemberDto> selectList(String column, String keyword){
		if(column == null || keyword == null) return selectList();
		if(column.isBlank() || keyword.isBlank()) return List.of();
		if(allowColumns.contains(column) == false) return List.of();
		
		String sql = "select * from member where instr("+column+", ?) > 0 order by member_no asc";
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, memberMapper);
	}
	
	//상세조회
	public MemberDto selectOne(long memberNo) {
		String sql = "select * from member where member_no=? ";
		Object[] params = {memberNo};
		List<MemberDto> list = jdbcTemplate.query(sql, memberMapper, params);
		return list.isEmpty() ? null : list.get(0);
	}
}
