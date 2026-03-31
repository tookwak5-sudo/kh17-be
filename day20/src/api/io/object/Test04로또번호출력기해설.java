package api.io.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Set;

public class Test04로또번호출력기해설 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//입력준비
		File target = new File("files", "lotto.kh");
		FileInputStream stream = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(stream);
		ObjectInputStream object = new ObjectInputStream(buffer); //오타주의하기
		
		//입력
		Set<Integer> lotto = (Set<Integer>)object.readObject(); // 경고가 발생함(내용물까지 완전히 책임지지 못한다는 경고)  
		//경고등 해결법 : 라이브러리를 통한 해결 or 클래스를 만들어서 해결이 가능하다
		//정리
		object.close();
		
		//입력받은 데이터를 이용하 ㄴ처리
		for(int number : lotto) // 만약 Set에 null값이 들어가 있다면 Integer로 써줘야함!!!!!!
		System.out.println("번호" + number);
	}
}
