package api.io.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class Test06로또번호출력기 {
	public static void main(String[] args) throws IOException {
		File target = new File("files", "lotto.kh");
		
		FileInputStream stream = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(stream);
		DataInputStream data = new DataInputStream(buffer);
		
		//읽자마자 출력 이렇게 하면 나에게 남아있는게 없음.. 출력만 가능 + 읽자마자 출력은 메모리 낭비가 심함
		for(int i = 0; i < 6; i++) {
			int number = data.readInt();
			System.out.println("번호 : " + number);
		}
		
		
		data.close();
	}
}
