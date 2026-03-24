package api.collection2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test02로또번호생성기 {
	public static void main(String[] args) {
		Set<Integer> numbers = new TreeSet<>();
		Random r = new Random();
//		for(int i = 0; i < 6; i++) {
//			int rotto = r.nextInt(45) + 1;
//			if(numbers.contains(rotto)) {
//				i--;
//			}
//			numbers.add(rotto);
//		}
		while(numbers.size() < 6) {
			int number = r.nextInt(45) + 1;
				numbers.add(number);
		}
		System.out.println(numbers);
		
		//정렬이 안되기 때문에 Tree를 쓰기!
//		Set<Integer> numbers = new HashSet<>();
//		Random r = new Random();
//		for(int i = 0; i < 6; i++) {
//			int rotto = r.nextInt(45) + 1;
//			if(numbers.contains(rotto)) {
//				i--;
//			}
//			else {
//				numbers.add(rotto);
//			}
//		}
//		System.out.println(numbers);
	}
}
