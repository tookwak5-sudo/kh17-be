package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test08포커게임2 {
	public static void main(String[] args) {
		
		List<String> decks = new ArrayList<>();
		
		List<String> cards = List.of("하트 A", "하트 1", "하트 2", "하트 3", "하트 4", "하트 5", "하트 6", "하트 7", "하트 8", "하트 9", "하트 10", "하트 J", "하트 Q", "하트 K"
		, "스페이드 A", "스페이드 1", "스페이드 2", "스페이드 3", "스페이드 4", "스페이드5", "스페이드 6", "스페이드7", "스페이드 8", "스페이드 9", "스페이드 10", "스페이드 J", "스페이드 Q", "스페이드 K"
		, "다이아 A", "다이아 1", "다이아 2", "다이아 3", "다이아 4", "다이아 5", "다이아 6", "다이아 7", "다이아 8", "다이아 9", "다이아 10", "다이아 J", "다이아 Q", "다이아 K"
		, "클로버 A", "클로버 1", "클로버 2", "클로버 3", "클로버 4", "클로버 5", "클로버 6", "클로버 7", "클로버 8", "클로버 9", "클로버 10", "클로버 J", "클로버 Q", "클로버 K");
		
		for(String card : cards) {
			decks.add(card);
		}
		
		Collections.shuffle(decks);
		//System.out.println(decks);
		
		List<Players> players = new ArrayList<>();
        players.add(new Players("플레이어 1"));
        players.add(new Players("플레이어 2"));
        players.add(new Players("플레이어 3"));
        players.add(new Players("플레이어 4"));
		
     // 3. 카드 배분 (클래스의 메소드 활용)
        int cardIndex = 0;
        for (int round = 0; round < 6; round++) {
            for (Players p : players) {
                p.addCard(cards.get(cardIndex++)); // 객체에게 "카드 가져가!"라고 시킴
            }
        }
        
     // 4. 결과 출력
        for (Players p : players) {
            p.showHand();
        }
	}
}
