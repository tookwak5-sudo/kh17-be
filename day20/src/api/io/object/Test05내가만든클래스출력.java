package api.io.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test05내가만든클래스출력 {
	public static void main(String[] args) throws IOException {
		//내가 만든 클래스의 객체도 출력이 될까??
		 
		//- 객체 출력을 하려면 해당 클래스 반드시 마킹 인터페이스(java.io.Serializable을 상속받아야함)
		 Student s = new Student("피카츄", 1, 70);
		 
		 //출력준비
		 File target =new File("files", "student.kh");
		 FileOutputStream	stream = new FileOutputStream(target);
		 BufferedOutputStream buffer = new BufferedOutputStream(stream);
		 ObjectOutputStream object = new ObjectOutputStream(buffer);
		 
		 //출력
		 object.writeObject(s);
		 
		 //종료
		 object.close();
		 System.out.println("저장완료");
		 
	}
}
