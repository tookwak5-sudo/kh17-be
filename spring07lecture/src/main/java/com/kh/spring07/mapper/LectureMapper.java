package com.kh.spring07.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring07.dto.LectureDto;

@Component //외부 도움 없이 스스로 작업을 해내는 도구(autowired가 없는 것)
public class LectureMapper implements RowMapper<LectureDto>{

	@Override
	public LectureDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		LectureDto lectureDto = new LectureDto();
		lectureDto.setLectureNo(rs.getLong("lecture_no"));
		lectureDto.setLectureTitle(rs.getString("lecture_title"));
		lectureDto.setLectureCategory(rs.getString("lecture_category"));
		lectureDto.setLectureDuration(rs.getInt("lecture_duration"));
		lectureDto.setLecturePrice(rs.getLong("lecture_price"));
		lectureDto.setLectureType(rs.getString("lecture_type"));
		return lectureDto;
	}
	
}
