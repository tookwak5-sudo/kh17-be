package com.kh.spring12.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.kh.spring12.entity.Station;

public interface StationRepository extends JpaRepository<Station, Long> {
	//기본 명령은 이미 존재
	
	//
	List<Station> findByLocationContainingOrderByStationNoAsc(String keyword);
	
	//수정 메소드 (JPQL) 구현
	//- 주의사항
	//- 등록, 수정, 삭제처럼 데이터베이스가 변하는 작업은 @Query + @Modifyiong 표시가 필요(@Qurey만 쓰면 조회처럼 처리하려고 함)
	//- 파라미터가 원시형이면 콜론 혹은 ?를 이용해서 네이밍 바인딩 또는 시퀀스 바인딩 모두가 가능 (:stationName 또는 ?1)
	//- 파라미터가 객체라면 :#{#객체명,필드명} 으로 사용해야 한다
	//- 이렇게 구현하면 @UpdateTimestamp가 자동 갱신되지 않음 (수동으로 처리해야함, JPQL의 CURRENT_TIMESTAMP값 사용)
	@Modifying
	@Query("""
		update Station s
		set    s.stationName = :#{#station.stationName} , 
			   s.location = :#{#station.location} ,
			   s.utime = CURRENT_TIMESTAMP
		where  s.stationNo = :#{#station.stationNo}
	""")
	int updateStation(Station station);
	
	
	@Query("""
		select s from Station s
		where stationName like concat(:keyword, '%')
		order by s.stationName, s.stationNo
	""")
	Page<Station> searchByKeyword(Pageable pageable, String keyword);
	
	// 역번호로 단일 검색
	@Query("""
			select s from Station s
			where s.stationNo = :keyword
			order by s.stationName, s.stationNo
		""")
	Page<Station> searchByKeyword2(Pageable pageable, String keyword);

	
}
