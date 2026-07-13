package com.kh.spring11.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring11.dto.LectureDto;
import com.kh.spring11.mapper.LectureMapper;
import com.kh.spring11.vo.LectureComplexRequestVO;
import com.kh.spring11.vo.PageVo;


//@Repository
public class LectureDaoSpringJDBC implements LectureDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private LectureMapper lectureMapper;
	
	//등록
	@Override
	public int sequence() {
		String sql = "select lecture_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	@Override
	public void insert(LectureDto lectureDto) {
		String sql = "insert into lecture("
				+ "lecture_no, lecture_title, lecture_category, "
				+ "lecture_duration, lecture_price, lecture_type) "
				+ "values(?, ?, ?, ?, ?, ?)";
		Object[] params = {
				lectureDto.getLectureNo(),
				lectureDto.getLectureTitle(), lectureDto.getLectureCategory(), lectureDto.getLectureDuration(),
				lectureDto.getLecturePrice(), lectureDto.getLectureType()
		};
		jdbcTemplate.update(sql, params);
	}
	
	//수정
	@Override
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
	@Override
	public boolean delete(int lecture_no) {
		String sql = "delete lecture where lecture_no = ?";
		Object[] params = { lecture_no };
		return jdbcTemplate.update(sql, params) > 0;
	}
	

	//상세검색
	@Override
	public LectureDto selectOne(int lectureNo) {
		String sql = "select * from lecture where lecture_no =?";
		Object[] params = {lectureNo};
		List<LectureDto> list = jdbcTemplate.query(sql, lectureMapper, params);
		return list.isEmpty() ? null : list.get(0);
	}
		
	//Rest API 용 페이징 메소드
	//- 동일 데이터가 두 번 나오지 않도록 번호를 필터링 하여 10개를 추출
	@Override
	public List<LectureDto> selectList(Integer lastLectureNo, int size){
		String sql = "select * from ( "
				+ "select rownum rn, TMP.* from ("
					+ "select * from lecture "
					+ "where lecture_no < ? "
					+ "order by lecture_no desc"
				+ ")TMP"
				+ ") where rn between 1 and ?";
		Object[] params = { lastLectureNo, size };
		return jdbcTemplate.query(sql, lectureMapper, params);
	}
	
	@Override
	public int count(int lastLectureNo) {
		String sql = "select count(*) from lecture where lecture_no < ?";
		Object[] params = { lastLectureNo };
		return jdbcTemplate.queryForObject(sql, int.class, params);
	}
	
	@Override
	public List<LectureDto> complexSearch(LectureComplexRequestVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int complexSearchCount(LectureComplexRequestVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
}
