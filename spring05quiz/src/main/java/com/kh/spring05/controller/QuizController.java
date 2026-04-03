package com.kh.spring05.controller;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController {
	
	// 주소생성 확인용
	@RequestMapping("/")
	public String home() {
		return "체크";
	}
	
	// 한국나이
	@RequestMapping("/quiz01")
	public String birth(@RequestParam int year) {
		LocalDate now =LocalDate.now();
		int age = now.getYear() - year + 1;
		return "한국 나이 : " + age;
	}
	
	//bmi
	@RequestMapping("/quiz02")
	public String bmi(@RequestParam double height, @RequestParam double weight) {
		double m = height / 100;
		double m2 = m * m;
		double bmi = weight / m2;
		return "BMI 지수 : " + bmi;
	}
	
	//기간
	@RequestMapping("/quiz03")
	public String period(@RequestParam String begin, @RequestParam String end) {
		LocalDate a = LocalDate.parse(begin);
		LocalDate b = LocalDate.parse(end);
		long days = ChronoUnit.DAYS.between(a, b);
		return "일" + days;
	}
	
	//총점 평균
	@RequestMapping("/quiz04")
	public String score(@RequestParam int k, @RequestParam int e, @RequestParam int m) {
		int total = k + e + m;
		double avg = total / 3d;
		
		return "총점 : " + total +"점 \t" + "평균 : " + avg + "점";
	}
	
	//지하철 요금
	@RequestMapping("/quiz05")
	public String subway(@RequestParam(defaultValue = "2001") int birth) {
		int age = LocalDate.now().getYear() - birth + 1; 
		
		if(age >= 65 || age < 6) return "무료";
		else if(age >= 19) return "성인 : " + 1550 + "원";
		else if(age >= 13) return "청소년 : " + 900 + "원";
		else return "어린이 : " + 550 + "원";
	}
	
//	@RequestMapping("/quiz05")
//	public String subway(@RequestParam(required = false) Integer birth) {
//		if(birth == null) {
//			return "성인 : " + 1550 + "원";
//		}
//		int age = LocalDate.now().getYear() - birth + 1; 
//		if(age >= 65 || age < 6) return "무료";
//		if(age >= 19) return "성인 : " + 1550 + "원";
//		if(age >= 13) return "청소년 : " + 900 + "원";
//		return "어린이 : " + 550 + "원";
//	}
	
	
	
	
	
}
