package com.kh.spring09.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.mapper.MemberMapper;

@Repository              //POJO(Plane Old java Ojbect) 클래스 지향
public class MemberDao { //Dao는 메소드를 자유롭게 가능 // mapper는 상속을 받았기 때문에 무조건 작성해줘야함
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private MemberMapper memberMapper;
	Set<String> allowColumns = Set.of(
			"member_id", "member_nickname", "member_contact", "member_level");
	
	//등록
	public void insert(MemberDto memberDto) {
		String sql = "insert into member("
				+ "member_id, member_email, member_password, "
				+ "member_nickname, member_birth, member_contact, "
				+ "member_post, member_address1, member_address2, "
				+ "member_message) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {
				memberDto.getMemberId(), memberDto.getMemberEmail(), memberDto.getMemberPassword(), 
				memberDto.getMemberNickname(), memberDto.getMemberBirth(), memberDto.getMemberContact(), 
				memberDto.getMemberPost(), memberDto.getMemberAddress1(), memberDto.getMemberAddress2(), 
				memberDto.getMemberMessage()
		};
		jdbcTemplate.update(sql, params);
	}
	
	//아이디조회
		public MemberDto selectOne(String memberId) {
		    String sql = "select * from member where member_id = ?";
		    Object[] params = {memberId};
		    List<MemberDto> list = jdbcTemplate.query(sql, memberMapper, params);
		    return list.isEmpty() ? null : list.get(0);
		}
	
	//수정 메소드
	
	public boolean updateMemberLogin(String memberId) {
		String sql = "update member set member_login = systimestamp where member_id=?";
		Object[] params = {memberId};
		return jdbcTemplate.update(sql, params) > 0;
	}
	
//	//비밀번호 변경
//	public boolean updateMemberPassword(String memberId, String memberPassword) {
	public boolean updateMemberPassword(MemberDto memberDto) {
		String sql = "update member "
				+ "set member_password = ?, member_change=systimestamp "
				+ "where member_id = ?";
		Object[] params = {memberDto.getMemberPassword(), memberDto.getMemberId()};
		return jdbcTemplate.update(sql, params) > 0;
	}
	
	//개인정보 변경
	public boolean update(MemberDto memberDto) { // 여기서도 비밀번호 검사를 넣을 수 있지만, DB에서 암호화를 처리하기 어렵기 때문에 처리 안함.
		String sql = "update member set "
				+ "member_email=?, "
				+ "member_nickname=?, "
				+ "member_birth=?, "
				+ "member_contact=?, "
				+ "member_post=?, "
				+ "member_address1=?, "
				+ "member_address2=?, "
				+ "member_message=? "
				+ "where member_id= ?";
		Object[] params = {
			memberDto.getMemberEmail(), memberDto.getMemberNickname(), memberDto.getMemberBirth(), 
			memberDto.getMemberContact(), memberDto.getMemberPost(), memberDto.getMemberAddress1(), 
			memberDto.getMemberAddress2(), memberDto.getMemberMessage(), memberDto.getMemberId() 
		};
		return jdbcTemplate.update(sql, params) > 0;
	}
	
	//삭제
	public boolean delete(String memberId) {
		String sql = "delete member where member_no =?";
		Object[] params = {memberId};
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
		if(column.isBlank() || keyword.isBlank()) return selectList();
		if(allowColumns.contains(column) == false) return List.of();
		
		String sql = "select * from member where instr("+ column +", ?) > 0 order by member_no asc";
		Object[] params = { keyword };
		return jdbcTemplate.query(sql, memberMapper, params);
	}
	
//	//상세조회
//	public MemberDto selectOne(long memberNo) {
//		String sql = "select * from member where member_no=? ";
//		Object[] params = {memberNo};
//		List<MemberDto> list = jdbcTemplate.query(sql, memberMapper, params);
//		return list.isEmpty() ? null : list.get(0);
//	}
//	
	
}
