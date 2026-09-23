package com.kh.spring12.station;

import java.beans.Transient;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.kh.spring12.entity.Pokemon;
import com.kh.spring12.entity.Station;
import com.kh.spring12.error.TargetNotfoundException;
import com.kh.spring12.repo.StationRepository;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class StationTest04역번호로역이름위치수정2 {
	@Autowired 
	private StationRepository stationRepository;
	
	@Test
	@Transactional
	public void test() {
		Station station = Station.builder()
				.stationNo(1L)
				.stationName("역삼역(KH정보교육원)")
				.location("서울시 강남구 역삼동")
			.build();
		
		//영속 객체 조회
		Station target = stationRepository.findById(station.getStationNo())
					.orElseThrow(()-> new TargetNotfoundException());
		
		//수정 (커스텀 메소드)
		stationRepository.updateStation(station);
		
	}
}
