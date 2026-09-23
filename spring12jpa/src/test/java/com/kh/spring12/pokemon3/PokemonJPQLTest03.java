package com.kh.spring12.pokemon3;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.entity.Pokemon;
import com.kh.spring12.repo.PokemonRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PokemonJPQLTest03 {
	
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Test
	public void test() {
		String keyword = "파";
		List<Pokemon> list = pokemonRepository.searchByKeyword(keyword);
		System.out.println("결과 = " + list.size());
		
		list.stream().forEach(System.out::println);
	}
}
