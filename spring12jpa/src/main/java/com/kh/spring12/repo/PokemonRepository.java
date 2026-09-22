package com.kh.spring12.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.spring12.entity.Pokemon;

//JPA에서 자동으로 CRUD를 처리할 수 있도록 관리되는 저장소(Repository)
//- 등록 필요없음 (인터페이스라 등록도 안됨... JPA가 자동으로 프록시 객체를 만들어 등록함)
//- 사용할 명령을 가진 인터페이스를 상속받고 PK 정보만 알려주면됨
//- extends JpaRepository<Pokemon, Long> : Long이 PK인 Pokemon에 대해 CRUD 수행할 관리도구 만들기 
public interface PokemonRepository extends JpaRepository<Pokemon, Long>{

}
