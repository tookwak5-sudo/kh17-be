package com.kh.spring12.pokemon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.kh.spring12.entity.Pokemon;
import com.kh.spring12.error.TargetNotfoundException;
import com.kh.spring12.repo.PokemonRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PokemonUpdateTest {
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Test
	@Transactional
	@Commit
	public void test() {
		//[상식] 수정을 하려면 PK와 수정할 정보가 있어야 한다 (다 바꿀수도 있고, 일부만 바꿀 수도 있고...)
		
		//변경할 정보들을 객체로 생성(=화면에서 넘어오는 정보 수신과 동일) // 내가 만든거 (영속성 없음, jpa가 관리)
		Pokemon p = Pokemon.builder()
					.pokemonNo(2L)
					.pokemonName("어쩌고1")
					.pokemonType("저쩌고1")
				.build();
		//상세조회 후 검증을 거쳐 정보를 수정하도록 처리 // JPA가 만들어준거(영속성 객체, JPA가 추적함) JPA의 영속성 java의 상태변화를 영구히 반영한다
		Pokemon target = pokemonRepository.findById(p.getPokemonNo())
									.orElseThrow(()->new TargetNotfoundException());
		BeanUtils.copyProperties(p, target, "pokemonNo", "pokemonWtime", "pokemonEtime");//제외할 항목 선언
		Pokemon result = pokemonRepository.save(target);
		System.out.println("<수정 결과>");
		System.out.println(result);
	}
}
