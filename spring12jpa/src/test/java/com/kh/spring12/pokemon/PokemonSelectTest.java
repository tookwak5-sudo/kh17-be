package com.kh.spring12.pokemon;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.entity.Pokemon;
import com.kh.spring12.repo.PokemonRepository;

import lombok.extern.slf4j.Slf4j;

// [기존 상식]
//- 조회는 최소한 3개를 만들어야 한다(목록, 검색, 상세)
//- 가능한 경우 페이징도 되어야 한다
//- 목록/검색의 반환형은 List<Pokemon> 이다
//- 상세의 반환형은 Pokemon or Null/Exception 이다

@Slf4j
@SpringBootTest
public class PokemonSelectTest {
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Test
	public void test() {
		//JPA에서 제공하는 메소드를 이용해서 조회
		//- findAll(()
		
		List<Pokemon> list = pokemonRepository.findAll();
		System.out.println("개수 = " + list.size());
		for(Pokemon p : list) {
			System.out.println("->" + p);
		}
	}
}
