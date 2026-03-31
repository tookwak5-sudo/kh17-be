package api.io.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test06내가만든클래스입력 {
	public static void main(String[] args) throws Exception {
		
		//입력준비
		File target = new File("files", "student.kh");
		FileInputStream stream = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(stream);
		ObjectInputStream object = new ObjectInputStream(buffer);
		
		//입력
		Student s = (Student) object.readObject();
		
		//정리
		object.close();
		
		System.out.println(s);
	}
}
