package com.kh.spring12.station;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.kh.spring12.entity.Station;
import com.kh.spring12.repo.StationRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class StationTest02역조회및호선번호검색2 {
	@Autowired 
	private StationRepository stationRepository;
	
	@Test
	public void test() {
		int pageNo = 1;
		int pageSize = 10;
		
		String keyword = "강";
		Pageable pageable = PageRequest.of(pageNo-1, pageSize, Sort.by("stationNo").ascending());
		
		Page<Station> result = stationRepository.searchByKeyword(pageable, keyword);
		System.out.println("결과 = " + result.getTotalElements());
		result.getContent().stream().forEach(System.out::println);
	}
}
