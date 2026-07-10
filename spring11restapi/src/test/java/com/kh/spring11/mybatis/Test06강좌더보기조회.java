package com.kh.spring11.mybatis;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring11.dao.LectureDao;
import com.kh.spring11.dto.LectureDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test06강좌더보기조회 {
		@Autowired
		private LectureDao lectureDao;
		
		@Test
		public void test() {
			int size = 10;
			List<LectureDto> list = lectureDao.selectList(100, size);
			//log.debug("list size = {}", list.size());
			//assert 태스트에서만 판정테스트가 가능하게 해주는 구문
			
			//Assertions.assertEquals(10, list.size());
			//assertEquals(10, list.size()); //list.size()가 10이어야 통과
			
			//Assertions.assertTrue(10, list.size());
			assertTrue(size >= list.size()); //list.size()가 10보다 작거나 같으면 통과
		}
		
}
