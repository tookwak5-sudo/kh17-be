package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test08포커게임해설객체지향 {
	public static void main(String[] args) {
		
//		Card card = new Card("하트", "4");
		//System.out.pirntln(card);
		
		//카드를 52장 만들려면?
		List<Card> deck = new ArrayList<>();
		
		deck.add(new Card("스페이드", "A"));
		deck.add(new Card("스페이드", "2"));
		deck.add(new Card("스페이드", "3"));
		deck.add(new Card("스페이드", "4"));
		deck.add(new Card("스페이드", "5"));
		deck.add(new Card("스페이드", "6"));
		deck.add(new Card("스페이드", "7"));
		deck.add(new Card("스페이드", "8"));
		deck.add(new Card("스페이드", "9"));
		deck.add(new Card("스페이드", "10"));
		deck.add(new Card("스페이드", "J"));
		deck.add(new Card("스페이드", "Q"));
		deck.add(new Card("스페이드", "K"));
		
		deck.add(new Card("하트", "A"));
		deck.add(new Card("하트", "2"));
		deck.add(new Card("하트", "3"));
		deck.add(new Card("하트", "4"));
		deck.add(new Card("하트", "5"));
		deck.add(new Card("하트", "6"));
		deck.add(new Card("하트", "7"));
		deck.add(new Card("하트", "8"));
		deck.add(new Card("하트", "9"));
		deck.add(new Card("하트", "10"));
		deck.add(new Card("하트", "J"));
		deck.add(new Card("하트", "Q"));
		deck.add(new Card("하트", "K"));
		
		deck.add(new Card("클로버", "A"));
		deck.add(new Card("클로버", "2"));
		deck.add(new Card("클로버", "3"));
		deck.add(new Card("클로버", "4"));
		deck.add(new Card("클로버", "5"));
		deck.add(new Card("클로버", "6"));
		deck.add(new Card("클로버", "7"));
		deck.add(new Card("클로버", "8"));
		deck.add(new Card("클로버", "9"));
		deck.add(new Card("클로버", "10"));
		deck.add(new Card("클로버", "J"));
		deck.add(new Card("클로버", "Q"));
		deck.add(new Card("클로버", "K"));
		
		deck.add(new Card("다이아", "A"));
		deck.add(new Card("다이아", "2"));
		deck.add(new Card("다이아", "3"));
		deck.add(new Card("다이아", "4"));
		deck.add(new Card("다이아", "5"));
		deck.add(new Card("다이아", "6"));
		deck.add(new Card("다이아", "7"));
		deck.add(new Card("다이아", "8"));
		deck.add(new Card("다이아", "9"));
		deck.add(new Card("다이아", "10"));
		deck.add(new Card("다이아", "J"));
		deck.add(new Card("다이아", "Q"));
		deck.add(new Card("다이아", "K"));
	}
}
