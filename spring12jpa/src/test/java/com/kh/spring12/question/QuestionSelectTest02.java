package com.kh.spring12.question;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.quiz.Question;
import com.kh.spring12.repo.QuestionRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class QuestionSelectTest02 {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Test
	public void test() {
		List<Question> list = questionRepository.findAll();
		System.out.println("등록된 문항 : " + list.size());
		for(Question question : list) {
			System.out.println(question);
		}
	}
}
