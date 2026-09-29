package com.kh.spring12.quiz;

import org.hibernate.type.NumericBooleanConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//하위 개체

@Entity //jpa가 관리하는 얘다
@Table(name = "choice")
@SequenceGenerator(
		name = "choice_seq",
		sequenceName = "choice_seq",
		initialValue = 1, allocationSize = 1
)
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Choice {
	@Id @GeneratedValue(generator = "choice_seq", strategy = GenerationType.AUTO)
	private Long choiceNo;
	@Column(nullable = false)
	@Lob//대용량인 경우(LargeObject) oracle 4000byte가 넘는(문자열의 한계)경우 clob사용했었음
	private String choiceContent;
	@Column
	@Convert(converter = NumericBooleanConverter.class)//숫자 <> 논리 변환기
	private boolean answer;
}
