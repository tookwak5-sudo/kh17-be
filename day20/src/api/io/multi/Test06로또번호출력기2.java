package api.io.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class Test06로또번호출력기2 {
	public static void main(String[] args) throws IOException {
		File target = new File("files", "lotto.kh");
		
		FileInputStream stream = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(stream);
		DataInputStream data = new DataInputStream(buffer);

		Set<Integer> lotto = new TreeSet<>();
		for(int i = 0; i < 6; i++) {
			int number = data.readInt();
			lotto.add(number);
		}
		data.close();
		
		//출력은 입력이종료된 이후에
		for(int number : lotto) {
			System.out.println("번호 : " + number);
		}
		
		
	}
}
