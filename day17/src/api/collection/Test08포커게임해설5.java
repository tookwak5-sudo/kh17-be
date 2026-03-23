package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test08포커게임해설5 {
	public static void main(String[] args) {
		//1차 목표 카드덱 1개를 만드는 것 (52장 스페이드 A 스페이드 2 스페이드 3 ... + 다이아 하트 클로버)
		
		List<String> shapes = List.of("스페이드", "하트", "다이아", "클로버");
		List<String> numbers = List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
		
		
		
		List<String> deck = new ArrayList<>();
		for(String shape : shapes) {
			for(String number : numbers) {
				String card = shape + " " + number;
				deck.add(card);
			}
		}
		
		//댁 석기
		Collections.shuffle(deck);
		
		//플레이어가 가져야 되는 카드 저장소를 구현
		List<List<String>> players = new ArrayList<>();
		players.add(new ArrayList());
		players.add(new ArrayList());
		players.add(new ArrayList());
		players.add(new ArrayList());
		
			for(int i = 0; i < 4*6; i++) {
				String card = deck.get(i);
				switch(i % 4) {
				case 0: 	players.get(0).add(card); 	break;
				case 1: 	players.get(1).add(card); 	break;
				case 2: 	players.get(2).add(card);	break;
				case 3:	players.get(3).add(card); 	break;
				}
			}
			
		//출력
		System.out.println("플레이어1 : " + players);
		System.out.println("플레이어2 : " + players);
		System.out.println("플레이어3 : " + players);
		System.out.println("플레이어4 : " + players);
	}
}
