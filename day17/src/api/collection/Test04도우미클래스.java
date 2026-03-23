package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test04도우미클래스 {
	public static void main(String[] args) {
		//Collection은 데이터 한 개를 무한히 저장할 수 있는 다양한 방식의 저장소를 통칭하는 클래스
		//- Collections 클래스를 사용하면 Collection계열
		
		List<Integer> numbers = new ArrayList<>();
		for(int i = 1; i <=45; i++) {
			numbers.add(i); // 저장소에 추가
		}
		
		System.out.println(numbers);
		
		//[1] 뒤집기
		Collections.reverse(numbers);
		System.out.println(numbers);
		
		//[2] 랜덤셔플
		Collections.shuffle(numbers);
		System.out.println(numbers);
		
		//[3] 정렬
		Collections.sort(numbers);
		System.out.println(numbers);
		
		//앞에서 6개만 잘라서 출력
		List<Integer> lotto = numbers.subList(0,6); 
		// 업캐스팅을 안할경우 subList로 변환해서 해야하는데, 
		//업캐스팅을 할 경우 List에 subList가 상속되어 있어 고민없이 사용가능하다 
		System.out.println("lotto = " + lotto);
	}
}
