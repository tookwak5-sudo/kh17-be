package com.kh.spring12.question;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.entity.quiz.Question;
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
		System.out.println("등록된 문항 : " + list.size()); //객체 출력 시 toString()을 자동호출하게 되고 무한루프에 빠짐
		for(Question question : list) {
			System.out.println(question);
//			System.out.print(question.getQuestionNo());
//			System.out.print(" / ");
//			System.out.print(question.getQuestionContent());
//			System.out.println();
		}
	}
}
