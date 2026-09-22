package com.kh.spring12.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//JPA의 Annotation
@Entity //이 클래스는 테이블과 연결되는 개체이다!
@Table(name = "pokemon")// 실제 연결될 테이블의 이름은 pokemon이다
@SequenceGenerator(
	name = "pokemon_seq", //JPA가 내부적으로 기억할 시퀀스 이름(실제 시퀀스 이름이 아님)
	sequenceName = "pokemon_seq", //실물 DB에 시퀀스 생성이 필요할 경우 만들어지 ㄹ이름
	initialValue = 1,//시퀀스 시작번호(기본 1)
//	allocationSize = 20//캐시 크기(오라클 기본값 20)
	allocationSize = 1 //연습용 캐시 미사용 설정
)

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Pokemon {
	@Id//이 항목은 Primary Key이다! (단, 가급적이면 raw type 사용은 자제할 것)
	@GeneratedValue(
			generator = "pokemon_seq", //생성돈 @SequenceGenerator 중에 name이 pokemon_seq인 항목을 연결해라!
			strategy = GenerationType.AUTO //미리 지정한 DB의 종류와 버전에 맞게 자동으로 처리해라!
	)//이 항목은 생성 시 시퀀스를 사용한다
	@Column
	private Long pokemonNo;
	@Column(nullable = false, length = 30)
	private String pokemonName;
	@Column(nullable = false, length = 30)
	private String pokemonType;
	
	//시간 추가
	//- 시간의 형식이 자유(Timestamp, Date, LocalDateTime, ....)
	//- @CreationTimestamp는 생성 시각이 자동 기록
	//- @UpdateTimestamp는 수정 시각이 자동 기록
	@CreationTimestamp
	private LocalDateTime pokemonWtime;
	@UpdateTimestamp
	private LocalDateTime pokemonEtime;
}
