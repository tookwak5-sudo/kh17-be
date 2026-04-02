package jdbc.program;

import jdbc.dao.CountryDao;
import jdbc.dto.CountryDto;

public class Test11국가상세정보 {
	public static void main(String[] args) {
		//입력
		int countryNo = 2; // int로 보기보단 역할(즉, primary key)로 기억
		
		//조회
		CountryDao countryDao = new CountryDao();
		CountryDto countryDto = countryDao.selectOne(countryNo);
		
		//출력
		System.out.println(countryDto);
	}
}
