package com.kh.spring12.pokemon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.entity.Pokemon;
import com.kh.spring12.repo.PokemonRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PokemonInsertTest {
	
	//JPA가 만든 처리객체가 자동으로 주입됨
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Test
	public void test() {
		pokemonRepository.save(
				Pokemon.builder()
					.pokemonNo(1L)
					.pokemonName("버터플")
					.pokemonType("비행")
				.build());
	}
}
