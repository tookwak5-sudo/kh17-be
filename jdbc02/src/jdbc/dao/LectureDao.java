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
}
