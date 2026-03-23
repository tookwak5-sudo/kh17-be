package api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test03로또번호생성기해설정렬 {
	public static void main(String[] args) {
		
		//목표 : 중복과 관계없이 1~45 정수 6개를 추첨해서 리스트에 저장
		//저장소 생성
		List<Integer> numbers = new ArrayList<>();
		//랜덤 도구 생성
		Random r = new Random();
		
		while(numbers.size() < 6) { // 아직 데이터가 6개가 되지 않았다면 
			//랜덤 숫자를 추천해서 저장소에 저장
			int number = r.nextInt(45) + 1;
			if(numbers.contains(number) == false) {
				numbers.add(number);
			}
			
			//출력
			System.out.println(numbers);
			
		}
		
	}
}
