package jdbc.program;

import jdbc.dao.CountryDao;

public class Test04국가정보삭제 {
	public static void main(String[] args) {
			//primary key를 삭제시키는 것 (번호가 아니라!)
		int countryNo = 33;
		
		//처리 : CountryDao -> delete()
		CountryDao countryDao = new CountryDao();
		boolean success = countryDao.delete(countryNo);
		
		if(success) {
			System.out.println("국가 정보가 삭제되었습니다.");
		}
		else {
			System.out.println("존재하지 않는 국가입니다.");
		}
	}
}
