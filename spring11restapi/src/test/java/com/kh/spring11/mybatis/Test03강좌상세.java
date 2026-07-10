package com.kh.spring11.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring11.dto.LectureDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test03강좌상세 {
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		int lectureNo = 1233;
		LectureDto lectureDto = sqlSession.selectOne("mapper.lecture.find", lectureNo);
		log.debug("lectureDto = {}", lectureDto);
	}
}
