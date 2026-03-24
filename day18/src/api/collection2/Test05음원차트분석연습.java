package api.collection2;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test05음원차트분석연습 {
	public static void main(String[] args) {
		//멜론차트
		List<String> melonChart = List.of(
				"SWIM", "Body to Body", "BANG BANG", "404 (New Era)", "RUDE!", 
				"Good Goodbye", "Hooligan", "Drawing", "사랑하게 될 거야", "Aliens");
		List<String> geniChart = List.of(
				"SWIM", "BANG BANG", "404 (New Era)", "Drawing", "Good Goodbye", 
				"Body to Body", "사랑하게 될 거야", "타임캡슐", "RUDE!", "Golden");
		// 1. 양대차트 Top100인 곡
		Set<String> both = new TreeSet<>();
		both.addAll(melonChart);
		both.retainAll(geniChart);
		System.out.println("<양쪽 차트 모두 top100인노래>");
		for(String title : both) {
			System.out.println("->" + title);
		}
		
		//2. 한쪽만 Top10인 곡
		//- 모든 곡을 합쳐서 both를 제거
		//- [멜론 - 지니] U [지니 - 멜론]
		Set<String> each = new TreeSet<>();
		each.addAll(melonChart);
		each.addAll(geniChart);
		each.removeAll(both);
		System.out.println("<한쪽 차트에서만 top100인노래>");
		for(String title : each) {
			System.out.println("->" + title);
		}
		
	}
}
