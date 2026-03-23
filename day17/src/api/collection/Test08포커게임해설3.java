package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test08포커게임해설3 {
	public static void main(String[] args) {
		//1차 목표 카드덱 1개를 만드는 것 (52장 스페이드 A 스페이드 2 스페이드 3 ... + 다이아 하트 클로버)
		
		List<String> deck = new ArrayList<>();
		deck.add("스페이드A");
		deck.add("스페이드2");
		deck.add("스페이드3");
		deck.add("스페이드4");
		deck.add("스페이드5");
		deck.add("스페이드6");
		deck.add("스페이드7");
		deck.add("스페이드8");
		deck.add("스페이드9");
		deck.add("스페이드10");
		deck.add("스페이드J");
		deck.add("스페이드Q");
		deck.add("스페이드K");
		
		deck.add("하트A");
		deck.add("하트2");
		deck.add("하트3");
		deck.add("하트4");
		deck.add("하트5");
		deck.add("하트6");
		deck.add("하트7");
		deck.add("하트8");
		deck.add("하트9");
		deck.add("하트10");
		deck.add("하트J");
		deck.add("하트Q");
		deck.add("하트K");
		
		deck.add("클로버A");
		deck.add("클로버2");
		deck.add("클로버3");
		deck.add("클로버4");
		deck.add("클로버5");
		deck.add("클로버6");
		deck.add("클로버7");
		deck.add("클로버8");
		deck.add("클로버9");
		deck.add("클로버10");
		deck.add("클로버J");
		deck.add("클로버Q");
		deck.add("클로버K");
		
		deck.add("다이아A");
		deck.add("다이아2");
		deck.add("다이아3");
		deck.add("다이아4");
		deck.add("다이아5");
		deck.add("다이아6");
		deck.add("다이아7");
		deck.add("다이아8");
		deck.add("다이아9");
		deck.add("다이아10");
		deck.add("다이아J");
		deck.add("다이아Q");
		deck.add("다이아K");
		
		//댁 석기
		Collections.shuffle(deck);
		
		//플레이어가 가져야 되는 카드 저장소를 구현
		List<String> player1 = new ArrayList();
		List<String> player2 = new ArrayList();
		List<String> player3 = new ArrayList();
		List<String> player4 = new ArrayList();
		
			for(int i = 0; i < 4*6; i++) {
				String card = deck.get(i);
				switch(i % 4) {
				case 0:
					player1.add(card);
					break;
				case 1:
					player2.add(card);
					break;
				case 2:
					player3.add(card);
					break;
				case 3:
					player4.add(card);
					break;
				}

			}
		//출력
		System.out.println("플레이어1 : " + player1);
		System.out.println("플레이어2 : " + player2);
		System.out.println("플레이어3 : " + player3);
		System.out.println("플레이어4 : " + player4);
	}
}
