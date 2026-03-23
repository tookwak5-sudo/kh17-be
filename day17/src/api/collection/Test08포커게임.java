package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test08포커게임 {
	public static void main(String[] args) {
		
		Random r= new Random();
		
		List<String> player1 = new ArrayList<>(); // 플레이어 입장
		List<String> player2 = new ArrayList<>();
		List<String> player3 = new ArrayList<>();
		List<String> player4 = new ArrayList<>();
		
		List<String> cards = List.of("하트 A", "하트 1", "하트 2", "하트 3", "하트 4", "하트 5", "하트 6", "하트 7", "하트 8", "하트 9", "하트 10", "하트 J", "하트 Q", "하트 K"
		, "스페이드 A", "스페이드 1", "스페이드 2", "스페이드 3", "스페이드 4", "스페이드5", "스페이드 6", "스페이드7", "스페이드 8", "스페이드 9", "스페이드 10", "스페이드 J", "스페이드 Q", "스페이드 K"
		, "다이아 A", "다이아 1", "다이아 2", "다이아 3", "다이아 4", "다이아 5", "다이아 6", "다이아 7", "다이아 8", "다이아 9", "다이아 10", "다이아 J", "다이아 Q", "다이아 K"
		, "클로버 A", "클로버 1", "클로버 2", "클로버 3", "클로버 4", "클로버 5", "클로버 6", "클로버 7", "클로버 8", "클로버 9", "클로버 10", "클로버 J", "클로버 Q", "클로버 K");
		
		for(int k = 0; k < 6; k++) {
			for(int i = 0; i < 1; i++) {
				if(player1.contains(cards) || player2.contains(cards) || player3.contains(cards) || player4.contains(cards) ) {
					i--;
				}
				int own = r.nextInt(cards.size());
				player1.add(cards.get(own));
				own = r.nextInt(cards.size());
				player2.add(cards.get(own));
				own = r.nextInt(cards.size());
				player3.add(cards.get(own));
				own = r.nextInt(cards.size());
				player4.add(cards.get(own));
			}
		}
		
		System.out.println("[플레이어 1]");
		for(int i = 0; i < 6; i++) {
			System.out.println("->" + player1.get(i));
		}
		System.out.println("[플레이어 2]");
		for(int i = 0; i < 6; i++) {
			System.out.println("->" + player2.get(i));
		}
		System.out.println("[플레이어 3]");
		for(int i = 0; i < 6; i++) {
			System.out.println("->" + player3.get(i));
		}
		System.out.println("[플레이어 4]");
		for(int i = 0; i < 6; i++) {
			System.out.println("->" + player4.get(i));
		}
		
		
		
		
		
		
		
		
		
		
	}
}
