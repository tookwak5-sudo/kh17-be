package jdbc.module;

import jdbc.dao.CountryDao;
import jdbc.dto.CountryDto;

public class Test01모듈화된국가등록 {
	public static void main(String[] args) {
		
		//입력
		CountryDto countryDto = new CountryDto();
		countryDto.setCountryRegion("유럽");
		countryDto.setCountryName("러시아");
		countryDto.setCountryCapital("모스크바");
		countryDto.setCountryPopulation(200000000L);
		
//		String countryRegion = "아시아";
//		String countryName = "몽골";
//		String countryCapital = "울란바토르";
//		long countryPopulation = 12000000L;
//		
		//처리
		//1. 테이블에 걸맞는 전담 처리클래스 객체를 생성한다
		//2. 지금 하려는 작업에 어울리는 메소드를 부른다
		CountryDao countryDao = new CountryDao();
		countryDao.insert(countryDto);
		
		
		//출력
		System.out.println("등록완료");
	}
}
