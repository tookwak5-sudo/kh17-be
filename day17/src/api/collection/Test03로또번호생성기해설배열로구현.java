package api.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test03로또번호생성기해설배열로구현 {
	public static void main(String[] args) {
		
		
		
		//저장소 생성
		int[] numbers = new int[6];
		//랜덤 도구 생성
		Random r = new Random();
		
		for(int i = 0; i < numbers.length; i++) {
			int number = r.nextInt(45) + 1;
			numbers[i] = number;
			
			for(int k=0; k < numbers.length; k++) {
				if(number == numbers[k]) {
					i--; // 현재회차를 무효화시키고
					break; // 검사중지
				}
			}
		}
		
		//정렬
		Arrays.sort(numbers);
		
		for(int i =0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}
}
