package api.io.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test03로또번호생성기 {
	public static void main(String[] args) throws IOException {
		
		//객체 준비
		Random r = new Random();

		Set<Integer> lotto = new TreeSet();
		while(lotto.size() < 6) {
			int number = r.nextInt(45) + 1;
			lotto.add(number);
		}// 뽑는 거 따로
		
		//출력 준비
		File target = new File("files", "lotto.kh");
		FileOutputStream stream = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(stream);
		ObjectOutputStream object = new ObjectOutputStream(buffer);
		
		//object에 준비한 객체를 내보내도록 지시
		object.writeObject(lotto);
		
		object.close();
		System.out.println("처리완료");
	}
}
