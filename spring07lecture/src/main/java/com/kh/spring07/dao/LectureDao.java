package com.kh.spring07.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring07.dto.LectureDto;
import com.kh.spring07.mapper.LectureMapper;

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
	
}
