package com.kh.spring05.controller;

import java.text.DecimalFormat;
import java.text.Format;
import java.time.LocalDate;
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
	
	@RequestMapping("/quiz01-1")
	public String current(@RequestParam int year, @RequestParam int month, @RequestParam int day) {
		LocalDate inputDate = LocalDate.of(year, month, day);
		LocalDate now = LocalDate.now();
		int age = now.getYear() - inputDate.getYear() + 1;
		return "한국 나이 : " + age;
	}
	
	@RequestMapping("/quiz01-2")
	public String current(@RequestParam String date) {
		LocalDate inputDate = LocalDate.parse(date);
		LocalDate now = LocalDate.now();
		int age = now.getYear() - inputDate.getYear() + 1;
		return "한국 나이 : " + age;
	}
	
	//bmi
	@RequestMapping("/quiz02")
	public String quiz02(@RequestParam double height, @RequestParam double weight) {
		double m = height / 100d;
		double bmi = weight / Math.pow(m, 2);
		Format f = new DecimalFormat("0.00");
		return "BMI 지수 : " + f.format(bmi);
	}
	
	//기간
//	@RequestMapping("/quiz03")
//	public String period(@RequestParam String begin, @RequestParam String end) {
//		LocalDate a = LocalDate.parse(begin);
//		LocalDate b = LocalDate.parse(end);
//		long days = ChronoUnit.DAYS.between(a, b);
//		return "기간" + days + "일";
//	}
	
	//end는 없을 수 있다
	@RequestMapping("/quiz03")
	public String quiz03(
			@RequestParam String begin, 
			//end는 없을 수 있도록 처리
			//null로 처리되는 게 싫으면 defaultVale로 값을 지정할 수 잇음
			@RequestParam(required = false) String end) {
		LocalDate a = LocalDate.parse(begin);
		LocalDate b = end  == null ? LocalDate.now() : LocalDate.parse(end);
		long days = ChronoUnit.DAYS.between(a, b);
		return "기간" + days + "일";
	}
	
	//총점 평균
	@RequestMapping("/quiz04")
	public String quiz04(
			@RequestParam int k, 
			@RequestParam int e, 
			@RequestParam int m) {
		int total = k + e + m;
		double avg = total / 3d;
		Format f = new DecimalFormat("#,##0.00");
		//return "총점 : " + total +"점 \t" + "평균 : " + f.format(avg) + "점";
//		return "총점 : " + total +"점 \n" + "평균 : " + f.format(avg) + "점";
		//\n적용이 안됨 
		// 홈페이지에 맞는 enter <br>을 입력하여 줄바꿈 적용
		return "총점 : " + total +"점 <br>" + "평균 : " + f.format(avg) + "점";
	}
	
	//지하철 요금
//	@RequestMapping("/quiz05")
//	public String quiz05(@RequestParam(defaultValue = "2001") int birth) {
//		int age = LocalDate.now().getYear() - birth + 1; 
//		
//		if(age >= 65 || age < 6) return "무료";
//		else if(age >= 19) return "성인 : " + 1550 + "원";
//		else if(age >= 13) return "청소년 : " + 900 + "원";
//		else return "어린이 : " + 550 + "원";
//	}
	
	//mapping은 다른 mapping의 도움을 받을 수 없다
	public String quiz05(@RequestParam(required = false, defaultValue = "0") int birth) {
		int age = LocalDate.now().getYear() - birth + 1; 
		int price;
		if(age >= 65 || age < 6) return "무료";
		else if(birth == 0 || age >= 19) return "성인 : " + 1550 + "원";
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
