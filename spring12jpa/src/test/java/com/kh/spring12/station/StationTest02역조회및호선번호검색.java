package com.kh.spring12.station;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.entity.Station;
import com.kh.spring12.repo.StationRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class StationTest02역조회및호선번호검색 {
	@Autowired 
	private StationRepository stationRepository;
	
	@Test
	public void test() {
//		List<Station> stationList = stationRepository.findAll();
//		Example<Station> example = Example.of(Station.builder().subwayLine("2호선").build());		
//		List<Station> stationList = stationRepository.findAll(example, Sort.by("stationNo").ascending());
		
//		기존 메소드로는 주소검색이 불가능하므로 컷ㅡ텀 네이밍 메소드 or JPQL or Native Query를 사용해야한다
		String keyword = "강남구";
		List<Station> stationList = stationRepository.findByLocationContainingOrderByStationNoAsc(keyword);
		
		System.out.println("역 개수 =" + stationList.size());
		for(Station station : stationList) {
			System.out.println(station.toString());
		}
		
	}
}
