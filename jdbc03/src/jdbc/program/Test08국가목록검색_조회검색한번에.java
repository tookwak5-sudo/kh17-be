package jdbc.program;

import java.util.List;

import jdbc.dao.CountryDao;
import jdbc.dto.CountryDto;

public class Test08국가목록검색_조회검색한번에 {
	public static void main(String[] args) {
		//입력
		String column = "country_population"; // 검색으로 처리
		String keyword = "1"; // 검색으로 처리 
//		String column = null; // 목록으로 처리하거나 차단 등 다른 작업을 하도록 지시
//		String keyword = null; // 목록으로 처리하거나 차단 등 다른 작업을 하도록 지시
		//위와 같은 경우는 막고싶음
		//처리
		CountryDao countryDao = new CountryDao();
		List<CountryDto> list = countryDao.selectList(column, keyword);
		
		//출력
		System.out.println("조회 결과 : " + list.size());
		for(CountryDto countryDto : list) {
			System.out.println(countryDto);
		}
	}
}
