package com.kh.spring12.question;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.quiz.Choice;
import com.kh.spring12.quiz.Question;
import com.kh.spring12.repo.QuestionRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class QuestionInsertTest01 {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Test
	public void test() {
		//문항과 보기4개를 합쳐서 등록
		
		Question question = Question.builder().questionContent("오늘 점심 추천 메뉴 중 정답은?").build();
		
		question.getChoices().add(Choice.builder().choiceContent("떡볶이").answer(false).build());
		question.getChoices().add(Choice.builder().choiceContent("라면").answer(false).build());
		question.getChoices().add(Choice.builder().choiceContent("김밥").answer(true).build());
		question.getChoices().add(Choice.builder().choiceContent("제육볶음").answer(false).build());
		
		questionRepository.save(question);
	}
}
