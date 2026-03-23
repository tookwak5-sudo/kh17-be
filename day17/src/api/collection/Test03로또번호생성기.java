package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test03로또번호생성기 {
	public static void main(String[] args) {
		Random r = new Random();
		List<Integer> roto = new ArrayList<>();
		
		for(int i = 0; i < 6; i++) {
			int rotoNumber = r.nextInt(45) + 1;
			roto.add(rotoNumber);
			if(roto.contains(roto)) {
				i--;
			}
		}
		Collections.sort(roto);
		System.out.println(roto.toString());
		
	}
}
