package com.kh.spring11.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring11.dto.LectureDto;

@SpringBootTest
public class Test01강좌등록 {
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		sqlSession.insert(
			"mapper.lecture.add", 
			LectureDto.builder()
				.lectureNo(1233)
				.lectureTitle("자바스터디")
				.lectureCategory("실습")
				.lectureDuration(30)
				.lecturePrice(30000)
				.lectureType("혼합")
				.build()
		);
	}
}
