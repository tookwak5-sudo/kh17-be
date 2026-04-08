package com.kh.spring09.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.LectureDto;
import com.kh.spring09.mapper.LectureMapper;


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
		public List<LectureDto> selectList(){
			String sql = "select * from lecture order by lecture_no asc";
			return jdbcTemplate.query(sql, lectureMapper);
		}
		
		//검색
		public List<LectureDto> selectList(String column, String keyword){
			
			if(column == null || keyword == null) return selectList();//또는 return List.of()
			Set<String> allowList = Set.of("lecture_title", "lecture_category", "lecture_type");
			if(!allowList.contains(column)) return selectList(); //또는 return List.of()
			
			String sql = "select * from lecture where instr("+ column +", ?) > 0 order by lecture_no asc";
			Object[] params = { keyword };
			return jdbcTemplate.query(sql, lectureMapper, params);
		}
		
		//상세검색
		public LectureDto selectOne(int lectureNo) {
			String sql = "select * from lecture where lecture_no =?";
			Object[] params = {lectureNo};
			List<LectureDto> list = jdbcTemplate.query(sql, lectureMapper, params);
			return list.isEmpty() ? null : list.get(0);
		}
}
