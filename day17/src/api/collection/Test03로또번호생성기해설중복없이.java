package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test03로또번호생성기해설중복없이 {
	public static void main(String[] args) {
		
		//목표 : 추첨된 번호를 정렬
		
		List<Integer> numbers = new ArrayList<>();
		//랜덤 도구 생성
		Random r = new Random();
		
		while(numbers.size() < 6) { // 아직 데이터가 6개가 되지 않았다면 
			//랜덤 숫자를 추천해서 저장소에 저장
			int number = r.nextInt(45) + 1;
			if(numbers.contains(number) == false) {
				numbers.add(number);
			}
		
		}
		//정렬
	//	numbers.sort(null); //numbers의 데이터를 "표준 방식"으로 정렬(= 오름차순)
		Collections.sort(numbers); // Collections라는 보조도구의 정렬기능을 사용하여 정렬(= 기본적으로 오름차순);
			
		//출력
			System.out.println(numbers);
			for(int i = 0; i < numbers.size(); i++) {
				System.out.println("번호 : " + numbers.get(i));
			}
		
	}
}
