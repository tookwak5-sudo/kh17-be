package oop.basic3;

public class Test01국가정보생성실습 {
	public static void main(String[] args) {
		Country c1 = new Country();
		Country c2 = new Country();
		Country c3 = new Country();
		
		c1.continent  = "아시아";
		c1.country =  "대한민국";
		c1.capital = "서울";
		c1.population = 51700000L; // 더하기 빼기가 가능
		
		c2.continent  = "유럽";
		c2.country =  "프랑스";
		c2.capital = "파리";
		c2.population = 68000000L;
		
		c3.continent  = "북아메리카";
		c3.country =  "캐나다";
		c3.capital = "오타와";
		c3.population = 40000000L; 
		
		System.out.println("<나라 정보>");
		System.out.println("대륙 : " + c1.continent);
		System.out.println("나라 : " + c1.country);
		System.out.println("수도 : " + c1.capital);
		System.out.println("인구수 : " + c1.population);
		System.out.println("-----------------------");
		
		System.out.println("<나라 정보>");
		System.out.println("대륙 : " + c2.continent);
		System.out.println("나라 : " + c2.country);
		System.out.println("수도 : " + c2.capital);
		System.out.println("인구수 : " + c2.population);
		System.out.println("-----------------------");
	
		System.out.println("<나라 정보>");
		System.out.println("대륙 : " + c3.continent);
		System.out.println("나라 : " + c3.country);
		System.out.println("수도 : " + c3.capital);
		System.out.println("인구수 : " + c3.population);
		System.out.println("-----------------------");
	}
}
