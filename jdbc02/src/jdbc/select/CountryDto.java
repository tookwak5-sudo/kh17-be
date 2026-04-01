package jdbc.select;

//Country 테이블의 한 줄을 보관할 클래스
// - 필드 + setter/getter + 기본생성자
public class CountryDto { // Dto (DataTransfer Object) 
	//필드 : DB 컬럼명과 동일하게 구성
		private long countryNo; // 번호도 long을 쓰는 경우도 많음
		private String countryRegion;
		private String countryName;
		private String countryCapital;
		private long countryPopulation;  // 만약 not null이 아닌 컬럼이 있다면 Long
		
		@Override
		public String toString() {
			return "CountryDto [countryNo=" + countryNo + ", countryRegion=" + countryRegion + ", countryName="
					+ countryName + ", countryCapital=" + countryCapital + ", countryPopulation=" + countryPopulation + "]";
		}
		

	public CountryDto() {
		}

	public long getCountryNo() {
		return countryNo;
	}
	public void setCountryNo(long countryNo) {
		this.countryNo = countryNo;
	}
	public String getCountryRegion() {
		return countryRegion;
	}
	public void setCountryRegion(String countryRegion) {
		this.countryRegion = countryRegion;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCapital() {
		return countryCapital;
	}
	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}
	public long getCountryPopulation() {
		return countryPopulation;
	}
	public void setCountryPopulation(long countryPopulation) {
		this.countryPopulation = countryPopulation;
	}
	
	

	
}
