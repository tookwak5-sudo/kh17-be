package com.kh.spring12.pokemon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.entity.Pokemon;
import com.kh.spring12.repo.PokemonRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PokemonInsertTest2 {
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Test
	public void test() {
		//ID에 시퀀스 설정이 된 경우 번호 설정이 필요하지 않다
		//→ 오히려 번호를 설정하면 수정하겠다는 뜻이 되어버린다
		//→ 등록을 하면 자동완성된 정보까지 모두 포함해서 반환시켜주므로 필요하면 사용 가능
		Pokemon p = pokemonRepository.save(
			Pokemon.builder()
//					.pokemonNo(1L)
				.pokemonName("버터플")
				.pokemonType("비행")
			.build()
		);
		
		log.info("p = {}", p);
	}
}
