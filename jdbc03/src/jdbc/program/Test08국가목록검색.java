package jdbc.program;

import java.util.List;

import jdbc.dao.CountryDao;
import jdbc.dto.CountryDto;

public class Test08국가목록검색 {
	public static void main(String[] args) {
		//입력
		String column = "country_name";
		String keyword = "시아";
				
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
