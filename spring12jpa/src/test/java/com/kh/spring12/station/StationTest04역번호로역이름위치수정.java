package com.kh.spring12.station;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.entity.Station;
import com.kh.spring12.error.TargetNotfoundException;
import com.kh.spring12.repo.StationRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class StationTest04역번호로역이름위치수정 {
	@Autowired 
	private StationRepository stationRepository;
	
	@Test
	public void test() {
		Station station = Station.builder()
				.stationNo(2L)
				.stationName("역삼역(KH정보교육원)")
				.location("서울시 강남구 역삼동")
			.build();
		
		//영속 객체 조회
		Station target = stationRepository.findById(station.getStationNo())
					.orElseThrow(()-> new TargetNotfoundException());
		
		//정보 치환 후 수정 처리
		target.setStationName(station.getStationName());
		target.setLocation(station.getLocation());
		
		//수정 (=등록, 단 ID가 존재해야함)
		stationRepository.save(target);
		
		System.out.println(target);
	}
}
