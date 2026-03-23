package api.collection;

public class Cards {
	// 1. 필드 (속성): 카드가 가져야 할 데이터
    String suit; // 모양 (예: 스페이드, 하트)
    String rank; // 숫자 (예: A, 2, 3, K)

    // 2. 생성자: 객체를 만들 때 초기값을 넣어주는 역할
    public Cards(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // 3. 메서드 (기능): 카드의 정보를 보여주는 기능
    public void showCard() {
        System.out.println("카드 정보: " + suit + " " + rank);
    }
}
