package com.kh.spring12.quiz;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//상위 개체
@Entity
@Table(name= "question")
@SequenceGenerator(
		name = "question_seq",
		sequenceName = "question_seq",
		initialValue = 1, allocationSize = 1
)
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Question {
	@Id @GeneratedValue(generator = "question_seq", strategy = GenerationType.AUTO)
	private Long questionNo;
	@Column(nullable = false)
	private String questionContent;
	@CreationTimestamp
	private LocalDateTime registTime;
	
	//항목은 아니지만 하위요소를 관리하기 위해 설정
	// - 이 개체 1개당 하위 개체가 N개 이므로 @OneToMany 사용
	// - Question이 Choice를 소유하는 형태가 됨
	@OneToMany(
		cascade = { CascadeType.PERSIST }, //PERSIST를 함께한다
		orphanRemoval = true//문항이 없는 보기는 모두 삭제한다 (상위요소와 연결되지 않은 하위요소는 모두 삭제한다)
	)
	@Builder.Default //빌더로 만들었을 때 기본값으로 가져가라
	private List<Choice> choices = new ArrayList<>();
}
