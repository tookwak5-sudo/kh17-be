package com.kh.spring12.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.spring12.entity.quiz.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{

}
