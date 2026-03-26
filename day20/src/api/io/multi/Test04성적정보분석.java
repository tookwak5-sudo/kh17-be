package api.io.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test04성적정보분석 {
	public static void main(String[] args) throws IOException {
		File scoreCheck = new File("files", "score.kh");
		
		FileInputStream stream = new FileInputStream(scoreCheck);
		BufferedInputStream buffer = new BufferedInputStream(stream);
		DataInputStream data = new DataInputStream(buffer);
		
		//아 배열은 크기가 정해져있을 때는 유리하지만 학생 10명이 고정이 아니라면 여기 바꿔줘야하기 때문에
		// List로 작성하면 더 좋겠구먼
		int[] getScore = new int[10];
		
		for(int i = 0; i< getScore.length; i++) {
			getScore[i] = data.readInt();
		}
		data.close();
		
		for(int i = 0; i < getScore.length; i++) {
			System.out.println("학생" + (i+1) + "의 성적 : " + getScore[i] + "점");
		}
		
		// 60점 이상
		int pass = 0;
		for(int i = 0; i < getScore.length; i++) {
			if(getScore[i] >= 60) {
				pass++;
			}
		}
		System.out.println("합격 인원 수 (60점 이상) : " + pass + "명");
		
		// 전체 합
		int sum = 0;
		for(int i = 0; i < getScore.length; i++) {
			sum += getScore[i];
		}
		// 평균
		double average = (double) sum / getScore.length; 
		System.out.println("전체 평균 점수 : " + average + "점");
	}
}
