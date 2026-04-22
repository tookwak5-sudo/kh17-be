package com.kh.spring09.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.LectureDto;
import com.kh.spring09.mapper.LectureMapper;
import com.kh.spring09.vo.PageVo;


@Repository
public class LectureDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private LectureMapper lectureMapper;
	
	//등록
	public void insert(LectureDto lectureDto) {
		String sql = "insert into lecture("
				+ "lecture_no, lecture_title, lecture_category, "
				+ "lecture_duration, lecture_price, lecture_type) "
				+ "values(lecture_seq.nextval, ?, ?, ?, ?, ?)";
		Object[] params = {
				lectureDto.getLectureTitle(), lectureDto.getLectureCategory(), lectureDto.getLectureDuration(),
				lectureDto.getLecturePrice(), lectureDto.getLectureType()
		};
		jdbcTemplate.update(sql, params);
	}
	
	//수정
		public boolean update(LectureDto lectureDto) {
			String sql = "update lecture set "
					+ "lecture_title =?, "
					+ "lecture_category =?, "
					+ "lecture_duration =?, "
					+ "lecture_price =?, "
					+ "lecture_type =? "
					+ "where lecture_no =?";
			Object[] params = {
					lectureDto.getLectureTitle(), lectureDto.getLectureCategory(),
					lectureDto.getLectureDuration(), lectureDto.getLecturePrice(),
					lectureDto.getLectureType(), lectureDto.getLectureNo()
			};
			return jdbcTemplate.update(sql, params) > 0; 
		}
	
		//삭제
		public boolean delete(int lecture_no) {
			String sql = "delete lecture where lecture_no = ?";
			Object[] params = { lecture_no };
			return jdbcTemplate.update(sql, params) > 0;
		}
		
		
		//조회
		public List<LectureDto> selectList(int beginRownum, int endRownum){
			String sql = "select * from lecture order by lecture_no asc";
			sql = "select * from( "
					+ "select rownum rn, TMP.* from("
					+ "select * from lecture order by lecture_no asc"
					+ ") TMP"
					+ ") where rn between ? and ?";
			Object[] params = {beginRownum, endRownum};
			return jdbcTemplate.query(sql, lectureMapper, params);
		}
		
		//검색
		public List<LectureDto> selectList(PageVo pageVo){
			
			if(pageVo.isList()) return selectList(pageVo.getBeginRownum(), pageVo.getEndRownum());//또는 return List.of()
			Set<String> allowList = Set.of("lecture_title", "lecture_category", "lecture_type");
			
			if(allowList.contains(pageVo.getColumn()) == false) 
				return List.of();
			
			String sql =  "select * from ("
					+ "select rownum rn, TMP.* from ("
					+ "select * from lecture "
					+ "where instr("+pageVo.getColumn()+", ?) > 0 "
					+ "order by country asc"
				+ ") TMP"
				+ ") where rn between ? and ?";
			Object[] params = { pageVo.getKeyword(), pageVo.getBeginRownum(), pageVo.getEndRownum() };
			return jdbcTemplate.query(sql, lectureMapper, params);
		}
		
		//상세검색
		public LectureDto selectOne(int lectureNo) {
			String sql = "select * from lecture where lecture_no =?";
			Object[] params = {lectureNo};
			List<LectureDto> list = jdbcTemplate.query(sql, lectureMapper, params);
			return list.isEmpty() ? null : list.get(0);
		}
		
		//카운트 메소드
		public int count() {
			String sql = "select count(*) from lecture";
			return jdbcTemplate.queryForObject(sql, int.class);
		}
		public int count(PageVo pageVo) {
			if(pageVo.isList()) return count();
			Set<String> allowList = Set.of("lecture_title", "lecture_category", "lecture_type");
			if(!allowList.contains(pageVo.getColumn()))
				return count();
			
			String sql = "select count(*) from lecture where instr("+pageVo.getColumn()+", ?) > 0";
			Object[] params = {pageVo.getKeyword()};
			return jdbcTemplate.queryForObject(sql, int.class, params);
		}
}
