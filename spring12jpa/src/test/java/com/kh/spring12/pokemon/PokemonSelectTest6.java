package com.kh.spring12.pokemon;

import java.util.Optional;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.entity.Pokemon;
import com.kh.spring12.repo.PokemonRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

// [기존 상식]
//- 조회는 최소한 3개를 만들어야 한다(목록, 검색, 상세)
//- 가능한 경우 페이징도 되어야 한다
//- 목록/검색의 반환형은 List<Pokemon> 이다
//- 상세의 반환형은 Pokemon or Default/Null/Exception 이다

@Slf4j
@SpringBootTest
public class PokemonSelectTest6 {
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Test
	@Transactional
	public void test() {
		//JPA에서 제공하는 메소드를 이용해서 조회
		//-> 번호가 5번인 몬스터를 조회
		
		// * findById를 사용하면 즉시(eager) 조회하는 전략을 사용함
		// * Java 8+에서 등장한 Optional 형태로 데이터를 반환 (데이터가 있을 수도 없을 수도 있어서 그에 따른 처리가 가능한 도구)
		
		Optional<Pokemon> p = pokemonRepository.findById(5L);
		if(p.isEmpty()) {
			System.out.println("존재하지 않는 몬스터 번호입니다");
		}
		else {
			System.out.println(p);
		}
	}
}
