package com.kh.spring12.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kh.spring12.entity.Pokemon;


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
	
	//페이징 적용
	//- 페이징은 조회 결과 외에도 정보가 많이 필요하다 (ex : 마지막인지, 전체가 몇갠지, 현재 어디인지, ...) → Page<T> 형태로 반환
	//- (1) pom.xml에 의존성 추가(hibernate-community-dialects) → JPA 설정 (spring.jpa.database-platform)
	//- (2) 커스텀 메소드 생성 시 반환형을 Page<T>로 설정해야 하며, 첫 번째 매개변수에 반드시 Pageable이 포함되어야 한다
	Page<Pokemon> findByPokemonNoGreaterThanEqual(Pageable pageable, int min);
	
	
	//[2] JPQL (Java Persistence Query Language)
	//- JPA에서 제공하는 중간단계 형태의 SQL 구문 (추가 변환을 DB에 따라 시켜주는 형태)
	//- @Query 애노테이션을 설정하고 JPQL 구문을 작성해야 구동됨
	//- 와일드카드 안됨, 테이블이 아니라 Entity의 이름을 기준으로 조회하므로 대소문자에 매우 민감함
	//- 나머지 구조는 기본 SQL과 비슷
	//- 메소드 이름 형식이 자유로워 진다
	@Query("select p from Pokemon p order by p.pokemonNo asc")
	List<Pokemon> selectList();
	
	
//	@Query("""
//		select p from Pokemon p 
//		where p.pokemonNo between ?1 and ?2
//		order by p.pokemonNo asc
//	""")
	@Query("""
			select p from Pokemon p 
			where p.pokemonNo between :min and :max
			order by p.pokemonNo asc
		""")
	List<Pokemon> between(int min, int max);
	
	// 문자열 검색은 like 또는 concat 사용 (instr은 오라클 전용)
//	@Query("""
//			select p from Pokemon p
//			where INSTR(pokemonName, :keyword) > 0
//			order by p.pokemonNo asc
//	""")
	@Query("""
			select p from Pokemon p
			where pokemonName like concat(:keyword, '%')
			order by p.pokemonName, p.pokemonNo
	""")
	List<Pokemon> searchByKeyword(String keyword);
	
	@Query("""
			select p from Pokemon p
			where pokemonName like concat(:keyword, '%')
			order by p.pokemonName, p.pokemonNo
	""")
	Page<Pokemon> searchByKeyword(Pageable pageable, String keyword);
	
	//[3] Native SQL 사용
	//- 네이밍메소드, JPQL로도 안되는 경우가 존재 (특정 DB에서만 가능한 기능)
	//- JPA 입장에서 봄변 최악이지만 그건 JPA의 사정일 뿐 필요한 순간이 반드시 존재 (ex: 트리정렬, 함수호출)
	//- @Query에 nativeQuery=true 설정 후 구문을 작성한다(DB구문)
	@Query(nativeQuery = true, value = """
		select * from pokemon	
	""")
	List<Pokemon> selectList2();
	
	@Query(nativeQuery = true, value = """
		select * from pokemon
		where instr(pokemon_name, :keyword) > 0
		order by pokemon_name, pokemon_no	
	""")
	List<Pokemon> searchByKeyword2(String keyword);
	
	@Query(nativeQuery = true, value = """
		select * from pokemon
		where pokemon_name like :keyword || '%'
		order by pokemon_name, pokemon_no	
	""")
	Page<Pokemon> searchByKeyword2(Pageable pageable, String keyword);
}
