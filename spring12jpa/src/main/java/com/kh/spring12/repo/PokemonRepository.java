package com.kh.spring12.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.spring12.entity.Pokemon;
import java.time.LocalDateTime;


//JPA에서 자동으로 CRUD를 처리할 수 있도록 관리되는 저장소(Repository)
//- 등록 필요없음 (인터페이스라 등록도 안됨... JPA가 자동으로 프록시 객체를 만들어 등록함)
//- 사용할 명령을 가진 인터페이스를 상속받고 PK 정보만 알려주면됨
//- extends JpaRepository<Pokemon, Long> : Long이 PK인 Pokemon에 대해 CRUD 수행할 관리도구 만들기 
public interface PokemonRepository extends JpaRepository<Pokemon, Long>{
	
	//[1] Naming Method를 만들어서 호출하면 구문이 생성된다
	//- 구문 : select * from pokemon where pokemon_no >= 100;
	//- 규칙 : findBy(조회) + 항목 + 상태 + 매개변수, 조건 병합 시 And / Or을 사용
	List<Pokemon> findByPokemonNoGreaterThanEqual(int min);
	List<Pokemon> findByPokemonNoGreaterThanEqualAndPokemonNoLessThanEqual(int min, int max);
	List<Pokemon> findByPokemonNoBetween(int min, int max);
	
	//(Q) 최근 일주일간 등록된 몬스터 조회(PokemonAdvancedTest02)
	List<Pokemon> findByPokemonWtimeAfter(LocalDateTime begin);
	List<Pokemon> findByPokemonWtimeBetween(LocalDateTime begin, LocalDateTime end);

	//(Q) 몬스터명 자동완성 검색(PokemonAdvancedTest03) + 번호순 정렬
	List<Pokemon> findByPokemonNameStartingWithOrderByPokemonNoAsc(String keyword);
	List<Pokemon> findByPokemonNameStartingWithOrderByPokemonNameAsc(String keyword);
	List<Pokemon> findByPokemonNameStartingWithOrderByPokemonNameAscPokemonNoAsc(String keyword);
}
