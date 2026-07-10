package com.kh.spring11.mybatis;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring11.dto.LectureDto;

@SpringBootTest
public class Test02강좌조회 {
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		List<LectureDto> list = sqlSession.selectList("mapper.lecture.list");
		for(LectureDto lectureDto : list) {
			System.out.println(lectureDto);
		}
	}
}
