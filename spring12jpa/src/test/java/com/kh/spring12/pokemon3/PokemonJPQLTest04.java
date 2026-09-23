package com.kh.spring12.pokemon3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.kh.spring12.entity.Pokemon;
import com.kh.spring12.repo.PokemonRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PokemonJPQLTest04 {
	
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Test
	public void test() {
		String keyword = "니";
		Pageable pageable = PageRequest.of(0, 10);
		
		
		Page<Pokemon> result = pokemonRepository.searchByKeyword(pageable, keyword);
		System.out.println("결과 = " + result.getTotalElements());
		result.getContent().stream().forEach(System.out::println);
	}
}
