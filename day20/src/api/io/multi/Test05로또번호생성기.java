package api.io.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test05로또번호생성기 {
	public static void main(String[] args) throws IOException {
		
		File target = new File("files", "lotto.kh");
		
		FileOutputStream stream = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(stream);
		DataOutputStream data = new DataOutputStream(buffer);
		
		Random r = new Random();

		Set<Integer> lotto = new TreeSet();
		while(lotto.size() < 6) {
			int number = r.nextInt(45) + 1;
			lotto.add(number);
		}// 뽑는 거 따로
		
		for(int number : lotto) {
			data.writeInt(number);
		} // 저장하는 거 따로
		
		data.close();
		System.out.println("로또 번호 생성완료");
	}
}
