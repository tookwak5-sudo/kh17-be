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
public class PokemonAdvancedTest2 {
	
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Test
	public void test() {
		//목표 : 최근 일주일간 등록된 몬스터 정보를 조회
		LocalDateTime today = LocalDateTime.now();
		LocalDateTime before7Days = today.minusDays(7L).withHour(0).withSecond(0);
//		List<Pokemon> list = pokemonRepository.findByPokemonWtimeAfter(before7Days);
		List<Pokemon> list = pokemonRepository.findByPokemonWtimeBetween(before7Days, today);
		
		System.out.println("결과 개수 =" + list.size());
		for(Pokemon p : list) {
			System.out.println(" -> " + p);
		}
	}
}
