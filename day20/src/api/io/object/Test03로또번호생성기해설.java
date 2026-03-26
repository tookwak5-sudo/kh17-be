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

public class Test03로또번호생성기해설 {
	public static void main(String[] args) throws IOException {
		//저장할 객체 준비
		Set<Integer> lotto = new TreeSet();
		Random r = new Random();
		while(lotto.size() < 6) {
			int number = r.nextInt(45) + 1;
			lotto.add(number);
		}
		
		//출력 준비
		File target = new File("files", "lotto.kh");
		FileOutputStream stream = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(stream); // 이게 없으면 내장버퍼를 씀 외장 버퍼를 만들어줘서 써야함
		ObjectOutputStream object = new ObjectOutputStream(buffer);
		
		//object에 준비한 객체를 내보내도록 지시
		object.writeObject(lotto);
		
		//정리
		object.close();
		System.out.println("처리완료");
	}
}
