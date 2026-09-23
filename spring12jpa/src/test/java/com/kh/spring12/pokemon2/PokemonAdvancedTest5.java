package com.kh.spring12.pokemon2;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.kh.spring12.entity.Pokemon;
import com.kh.spring12.repo.PokemonRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PokemonAdvancedTest5 {
	
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Test
	public void test() {
		//목표 : 전체목록의 1페이지(10개씩) 조회
		int pageNo = 1;
		int pageSize = 10;
		
//		Pageable option = PageRequest.of(pageNo-1, pageSize);
		Pageable option = PageRequest.of(pageNo-1, pageSize, Sort.by("pokemonNo").ascending());
		Page<Pokemon> page = pokemonRepository.findByPokemonNoGreaterThanEqual(option, 100); //기본옵션 메소드
		
		System.out.println(page.getTotalPages()); //전체 페이지 수
		System.out.println(page.getTotalElements());//전체 데이터 수
		System.out.println(page.hasNext()); //다음이 있는지
		System.out.println(page.isLast()); //마지막인지
		System.out.println(page.isFirst()); //처음인지
		
		List<Pokemon> list = page.getContent();//데이터 추출
		for(Pokemon p : list) {
			System.out.println(p);
		}
	}
}
