package com.kh.spring12.pokemon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.entity.Pokemon;
import com.kh.spring12.error.TargetNotfoundException;
import com.kh.spring12.repo.PokemonRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PokemonDeleteTest {
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Test
	public void test() {
		long pokemonNo = 1L;
		
		//[1] 객체를 이용해서 삭제
//		Pokemon target = pokemonRepository.findById(pokemonNo)
//				.orElseThrow(()->new TargetNotfoundException());
		
//		pokemonRepository.delete(target);
		
		//[2] ID를 전달하여 삭제
		Pokemon target = pokemonRepository.findById(pokemonNo)
				.orElseThrow(()->new TargetNotfoundException());
		
		pokemonRepository.deleteById(pokemonNo);
		
	}
}
