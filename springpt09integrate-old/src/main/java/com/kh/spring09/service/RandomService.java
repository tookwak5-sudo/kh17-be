package com.kh.spring09.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RandomService {
	//목적: 랜덤과 관련된 처리를 하기 위해서
	
	private Random r = new Random();
	
	private String numbers = "0123456789";
	private String lowerCases = "abcdefghijklmnopqrstuvwxyz";
	private String upperCases = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	//number 생성 //자릿수가 정해져있을 때 만들기 쉬운 방식
	public String generateNumber(int size) {
		StringBuffer buffer = new StringBuffer(); //버퍼 생성
		for(int i=0; i < size; i++) { // 너가 입력한 숫자만큼 size번 
			int index = r.nextInt(numbers.length()); //위치선정
			char ch = numbers.charAt(index); //해당 위치 글자 추출
			buffer.append(ch);  //버퍼에 추가
		}
		return buffer.toString(); //반환
	}
}
