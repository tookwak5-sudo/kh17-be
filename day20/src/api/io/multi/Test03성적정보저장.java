package api.io.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test03성적정보저장 {
	public static void main(String[] args) throws IOException {
		//파일과 스트림을 준비하고 10명의 성적정보를 저장
		
		//준비물 생성
		File scoreInfo = new File("files", "score.kh");
		
		FileOutputStream stream = new FileOutputStream(scoreInfo);
		BufferedOutputStream buffer = new BufferedOutputStream(stream, 1024);// 크기를 조절할 수도 있음
		DataOutputStream data = new DataOutputStream(buffer);
		
		Scanner sc = new Scanner(System.in);
		
		//굳이 배열로 쓸 이유가 없네.. 
		for(int i = 0; i< 10; i++) {
			System.out.print("점수" );
			int score = sc.nextInt();
			data.writeInt(score);
		}
		
	
		
		data.close();
		sc.close();
		System.out.println("저장 완료");
	}
}
