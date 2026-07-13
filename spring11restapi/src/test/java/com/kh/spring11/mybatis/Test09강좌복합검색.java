package com.kh.spring11.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring11.dto.LectureDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test09강좌복합검색 {
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		//선택적으로 구문에 데이터를 추가
		Map<String, Object> params = new HashMap<>();
//		params.put("lectureCategories", List.of("시험", "실습", "이론"));
//		params.put("minLectureDuration", 30);
//		params.put("maxLectureDuration", 120);
//		params.put("minLecturePrice", 100000);
//		params.put("maxLecturePrice", 1000000);
		params.put("lectureTypes", List.of("온라인", "오프라인", "혼합"));
//		params.put("size", 20);
//		params.put("lectureTitle", "테");
		
		params.put("orders", List.of(
				"lecture_price desc",
				"lecture_title asc"
				));
		
		List<LectureDto> list = sqlSession.selectList(
				"mapper.lecture.complexSearch", params);
		log.debug("결과 수 : {}", list.size());		
		for(LectureDto lectureDto : list) {
			log.debug(lectureDto.toString());
		}
	}
}
