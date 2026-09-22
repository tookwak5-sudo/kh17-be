package com.kh.spring12.pokemon;

import java.util.List;

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
//- 상세의 반환형은 Pokemon or Null/Exception 이다

@Slf4j
@SpringBootTest
public class PokemonSelectTest5 {
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Test
	@Transactional
	public void test() {
		//JPA에서 제공하는 메소드를 이용해서 조회
		//-> 번호가 5번인 몬스터를 조회
		
		// * JPA가 추구하는건 자동최적화이므로 조회를 하는 시점에 실제 구문을 실행하는게 아니라 값을 쓸 때 실제 구문을 실행하려고 한다
		Pokemon p = pokemonRepository.getOne(5L);
		if(p == null) {
			System.out.println("존재하지 않는 몬스터 번호입니다");
		}
		else {
			System.out.println(p.getPokemonNo());
			System.out.println(p.getPokemonName());
			System.out.println(p.getPokemonType());
		}
	}
}
