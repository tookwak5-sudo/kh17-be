package api.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test07불변리스트와확장반복 {
	public static void main(String[] args) {
		//데이터가 정해져 있을때는 좀 더 입게 만들 수 있는 방법이 없을까?
		//- 불변 리스트(immutable list)생성
		//- 불변 리스트는 생성 이후의 추가 삭제가 안됨
		
//		String[] fruit = new String[] {"사과", "딸기", "바나나", "포도", "복숭아"};
//		List<String> fruit = Arrays.asList("사과", "딸기", "바나나", "포도", "복숭아");
		List<String> fruit = List.of("사과", "딸기", "바나나", "포도", "복숭아");
		//fruit.remove(0); //예외발생
//		Collections.shuffle(fruit);
		System.out.println("fruit = " + fruit);  // 한번 만들어지면 크기와 위치가 고정됨
		
		//List와 같이 데이터를 여러 개 가지는 저장소들의 특징을 literable(나열할 수 있는)이라고 부름
		// - literable의 특징을 가지는 도구들 (ex: 배열, List,...)은 확장반복이란 것을 이용할 수 있다.
		for(String name : fruit) { //fruit에 있는 데이터들을 name에 순서대로 넘겨라! 전부다!!! (왼쪽 변수 : 오른쪽 저장소)
			System.out.println("name =" + name);
		}
	}
}
