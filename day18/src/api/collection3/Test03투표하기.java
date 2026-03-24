package api.collection3;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Test03투표하기 {
	public static void main(String[] args) {
		//저장소 생성(map)
		//	Map<이름, 투표수>
		Map<String, Integer> person = new TreeMap<>();
		
		Scanner sc = new Scanner(System.in);
		String name;
		while(true) {
			//이름 입력
			name = sc.nextLine();  //띄어쓰기 포함해서 온전한 문자를 받을 수 있는 유일한 입력어 nextLine()
			if(name.equals("종료")) break;
			
			//입력한 이름이 기존에 없다면
			if(person.containsKey(name) == false) {
				person.put(name, 1);
				System.out.println("[ " + name + " ] 현재" + 1 + "표 획득");
			}
			else{ // 기존에 이름이 있다면
				int count = person.get(name);
				person.put(name, count + 1);
				System.out.println("[ " + name + " ] 현재" + person.get(name) + "표 획득");
			}
		}
		sc.close();
		Set<String> names = person.keySet();
		for(String voted : names) {
			int count = person.get(voted);
			System.out.println(voted + ": " + count);
		}
	}
}
