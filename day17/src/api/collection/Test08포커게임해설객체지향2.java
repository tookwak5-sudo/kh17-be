package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test08포커게임해설객체지향2 {
	public static void main(String[] args) {
		
		List<String> shapes = List.of("스페이드", "하트", "다이아", "클로버");
		List<String> numbers = List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
		
		List<Card> deck = new ArrayList<>();
		
		for(String shape : shapes) {
			for(String number : numbers) {
				Card card = new Card(shape, number);
			}
		}
	}
}
