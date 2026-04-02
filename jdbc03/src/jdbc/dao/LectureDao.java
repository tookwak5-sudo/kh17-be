package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.LectureDto;
import jdbc.util.JdbcUtils;

public class LectureDao {
	public void insert(LectureDto lectureDto) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create(); // 이 한 줄로 DB 도구 생성이 끝남
		String sql = "insert into lecture("
				+ "lecture_no, lecture_title, lecture_category,"
				+ " lecture_duration, lecture_price, lecture_type"
				+ ") "
				+ "values(lecture_seq.nextval, ?, ?, ?, ?, ?)";
		Object[] params = {
				lectureDto.getLectureTitle(),lectureDto.getLectureCategory(), lectureDto.getLectureDuration(), 
				lectureDto.getLecturePrice(), lectureDto.getLectureType()
		};
		jdbcTemplate.update(sql, params);
	}
	public boolean update(LectureDto lectureDto) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
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
//		int row = jdbcTemplate.update(sql, params);
//		return row > 0;
	}
	
	//삭제
	public boolean delete(int lecture_no) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "delete lecture where lecture_no = ?";
		Object[] params = { lecture_no };
		return jdbcTemplate.update(sql, params) > 0;
	}
}
