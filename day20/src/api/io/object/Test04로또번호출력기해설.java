package api.io.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Set;

public class Test04로또번호출력기해설 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		File target = new File("files", "lotto.kh");
		FileInputStream stream = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(stream);
		ObjectInputStream object = new ObjectInputStream(buffer);
		
		Set<Integer> lotto = (Set<Integer>) object.readObject();
		
		object.close();
		
		for(int number : lotto)
		System.out.println(number);
	}
}
