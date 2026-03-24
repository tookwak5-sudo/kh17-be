package api.collection3;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test04맵전체출력 {
	public static void main(String[] args) {
		Map<String, Integer> votes = Map.of(
				"BTS", 30,
				"아이브", 25,
				"아이유", 20,
				"블랙핑크", 15
				);
				
		//개별 관리에 특화딘 Map이더라도 혹시 전체 출력은 안될까?
		//1.Map에서 Key만 보면 Set이므로 변환해서 사용
		Set<String> names = votes.keySet();
		for(String name : names) {
			int count = votes.get(name); //이름에 대한 값을 가져와서
			System.out.println(name + ":" + count);
		}
		//2.Map에서 제공하는 중첩클래스인 Entry라는 것이 존재하는데 이를 사용
//		Set<Map.Entry<String, Integer>> entries = votes.entrySet();
//		for(Map.Entry<String, Integer> entry : entries) {
		for(Entry<String, Integer> entry : votes.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
}
