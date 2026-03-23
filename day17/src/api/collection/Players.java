package api.collection;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private String name;
    private List<String> hand = new ArrayList<>(); // 플레이어의 카드 덱

    public Players(String name) {
        this.name = name;
    }

    // 카드를 한 장 받는 메소드
    public void addCard(String card) {
        hand.add(card);
    }

    // 현재 가진 카드를 보여주는 메소드
    public void showHand() {
        System.out.println(name + "의 카드: " + hand);
    }
}