package com.kh.spring12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.entity.Station;
import com.kh.spring12.error.TargetNotfoundException;
import com.kh.spring12.repo.StationRepository;

import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/station")
@RequiredArgsConstructor // 선언된 모든 필드를 생성자로 전달받음 (아주 강력한 결합을 유지, @Autowired의 대안)
public class StationRestController {
	
	// 기존 형태
//	@Autowired
//	private StationRepository stationRepository;
	
//	@RequiredArgsConstructor가 있을 때 - final 선언 필요
	private final StationRepository stationRepository;

	@PostMapping(value ="/", produces = "application/json")
	public Station create(@RequestBody Station station) {
		return stationRepository.save(station);
	}
	
	@GetMapping(value="/", produces ="application/json")
	public List<Station> list() {
		return stationRepository.findAll(Sort.by("stationNo").ascending());
	}
	
	//경로변수의 경우 정규표현식을 진행할 수 있다
	@GetMapping(value = "/{stationNo:[0-9]+}", produces= "application/json")
	public Station detail(@PathVariable long stationNo) { //PathVariable은 null이 불가능
		return stationRepository.findById(stationNo)
								.orElseThrow(()->new TargetNotfoundException());
	}
	
	@PutMapping(value = "/{stationNo:[0-9]+}", produces= "application/json")
	public Station edit(@PathVariable long stationNo, @RequestBody Station station) {
		Station target = stationRepository.findById(stationNo)
					.orElseThrow(()-> new TargetNotfoundException());
		target.setStationName(station.getStationName());
		target.setLocation(station.getLocation());
		target.setSubwayLine(station.getSubwayLine());
		return stationRepository.save(target);
	}
	
	@DeleteMapping(value="/{stationNo:[0-9]+}")
	public void delete(@PathVariable long stationNo) {
		Station target = stationRepository.findById(stationNo)
				.orElseThrow(()-> new TargetNotfoundException());
		stationRepository.delete(target);
	}
}
