package api.collection2;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test05음원차트분석 {
	public static void main(String[] args) {
		//멜론차트
		List<String> melonChart = List.of("SWIM", "Body to Body", "BANG BANG", "404 (New Era)", "RUDE!", "Good Goodbye", "Hooligan", "Drawing", "사랑하게 될 거야", "Aliens");
		List<String> geniChart = List.of("SWIM", "BANG BANG", "404 (New Era)", "Drawing", "Good Goodbye", "Body to Body", "사랑하게 될 거야", "타임캡슐", "RUDE!", "Golden");
		
		//교집합
		Set<String> both = new TreeSet<>();
		both.addAll(melonChart);
		both.retainAll(geniChart);
		
		for(String title : both) {
			System.out.println(title);
		}
		
		//합집합
		Set<String> all = new TreeSet<>();
		all.addAll(melonChart);
		all.addAll(geniChart);
		
		//교집합의 여집합
		Set<String> each = new TreeSet<>();
		each.addAll(all);
		each.removeAll(both);
		System.out.println("[한쪽만 Top100인 곡]");
		for(String title : each) {
			System.out.println(title);
		}
	}
}
