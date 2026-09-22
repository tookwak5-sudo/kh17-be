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
public class PokemonSelectTest4 {
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Test
	public void test() {
		//JPA에서 제공하는 메소드를 이용해서 조회
		//-> 특정 ID의 정보를 제공해서 해당 항목만 조회 (1, 3, 5, 7, 9번만 조회)
		//                                             [Iterable]
		//+ select * from pokemon where pokemon_no in (1,3,5,7,9)
		
		List<Pokemon> list = pokemonRepository.findAllById(List.of(1L,3L,5L,7L,9L));
		System.out.println("개수 = " + list.size());
		for(Pokemon p : list) {
			System.out.println("->" + p);
		}
	}
}
