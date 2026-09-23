package com.kh.spring12.station;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.entity.Station;
import com.kh.spring12.repo.StationRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class StationTest01역등록 {
	@Autowired 
	private StationRepository stationRepository;
	
	@Test
	public void test() {
		Station result = stationRepository.save(
			Station.builder()
				.stationName("역삼역")
				.subwayLine("2호선")
				.location("서울특별시 강남구 역삼동")
			.build()
		);
		
		System.out.println(result);
	}
}
