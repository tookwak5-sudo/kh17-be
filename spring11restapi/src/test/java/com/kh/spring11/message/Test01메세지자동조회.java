package com.kh.spring11.message;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring11.vo.message.MessageVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test01메세지자동조회 {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		List<MessageVO> list = sqlSession.selectList("mapper.message.selectTest", 1);
		log.debug("메세지 수 = {}", list.size());
		
		for(Object obj : list) {
			log.debug("obj = {}", obj.getClass());
		}
	}
}
