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
public class StationTest05 {
	@Autowired 
	private StationRepository stationRepository;
	
	@Test
	public void test() {
		long stationNo = 2L;
		
		//영속성 객체 조회
		Station target = stationRepository.findById(stationNo)
					.orElseThrow(()-> new TargetNotfoundException());
		
		//삭제
		stationRepository.delete(target);
//		stationRepository.deleteById(stationNo); //원하는 방식으로, 지금 흐름상 어울리는건 위쪽
	}
}
