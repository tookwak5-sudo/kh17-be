package com.kh.spring12.station;

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
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class StationTest06 {
	@Autowired 
	private StationRepository stationRepository;
	
	@Test
	public void test() {
		Station s = Station.builder()
				.stationNo(1L)
				.stationName("강남2역")
				.location("강남역 수리중")
			.build();
		
		Station target = stationRepository.findById(s.getStationNo())
					.orElseThrow(()-> new TargetNotfoundException());
		BeanUtils.copyProperties(s, target, "stationNo", "stationWtime", "subwayLine", "etime");
	}
}
