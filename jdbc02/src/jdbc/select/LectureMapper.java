package jdbc.select;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LectureMapper implements RowMapper<LectureDto>{
	@Override
	public LectureDto mapRow(ResultSet rs, int idx) throws SQLException {
		LectureDto lectureDto = new LectureDto();
		
		lectureDto.setLectureNo(rs.getLong("lecture_no"));
		lectureDto.setLectureTitle(rs.getString("lecture_title"));
		lectureDto.setLectureCategory(rs.getString("lecture_category"));
		lectureDto.setLecturePrice(rs.getInt("lecture_price"));
		lectureDto.setLectureDuration(rs.getString("lecture_duration"));
		lectureDto.setLectureType(rs.getString("lecture_type"));
		return lectureDto;
	}



	
}
