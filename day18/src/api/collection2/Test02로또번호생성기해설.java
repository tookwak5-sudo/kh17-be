package api.collection2;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test02로또번호생성기해설 {
	public static void main(String[] args) {
		Set<Integer> numbers = new TreeSet<>();
		Random r = new Random();
		while(numbers.size() < 6) {
			int number = r.nextInt(45) + 1;
				numbers.add(number);
		}
		//System.out.println(numbers);
		//(Q) Set에 담긴 데이터도 List처럼 반복문으로 출력이 되는가?
		//(A) 제한적으로 가능.. index에 의한 접근은 안되지만 확장 반복은 가능
		
		//for(int i = 0; i < numbers.size(); i++) // 불가
		for(int rottoNumber : numbers) {
			System.out.println("번호 : " + rottoNumber);
		}
	}
	
	
}
