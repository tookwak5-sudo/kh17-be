package com.kh.spring12.pokemon2;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.entity.Pokemon;
import com.kh.spring12.repo.PokemonRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PokemonAdvancedTest01 {
	
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Test
	public void test() {
		//목표 : 100번 이후의 포켓몬스터 정보를 조회
//		List<Pokemon> list = pokemonRepository.findByPokemonNoGreaterThanEqual(100);
//		System.out.println("검색결과 : " + list.size());
		
		//목표 : 100번~130번 사이의 포켓몬스터 정보를 조회
//		List<Pokemon> list = pokemonRepository.findByPokemonNoGreaterThanEqualAndPokemonNoLessThanEqual(100, 130);
		List<Pokemon> list = pokemonRepository.findByPokemonNoBetween(100, 130);
		
		System.out.println("검색 결과 =" + list.size());
	}
}
