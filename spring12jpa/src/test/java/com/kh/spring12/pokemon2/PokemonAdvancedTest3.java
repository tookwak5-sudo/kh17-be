package com.kh.spring12.pokemon2;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.entity.Pokemon;
import com.kh.spring12.repo.PokemonRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PokemonAdvancedTest3 {
	
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Test
	public void test() {
		//목표 :키워드에 해당하는 몬스터명 자동완성 검색결과 조회
		String keyword = "파";
//		List<Pokemon> list = pokemonRepository.findByPokemonNameStartingWithOrderByPokemonNoAsc(keyword);
//		List<Pokemon> list = pokemonRepository.findByPokemonNameStartingWithOrderByPokemonNameAsc(keyword);
		List<Pokemon> list = pokemonRepository.findByPokemonNameStartingWithOrderByPokemonNameAscPokemonNoAsc(keyword);
		
		System.out.println("결과 개수 =" + list.size());
		for(Pokemon p : list) {
			System.out.println(" -> " + p);
		}
	}
}
