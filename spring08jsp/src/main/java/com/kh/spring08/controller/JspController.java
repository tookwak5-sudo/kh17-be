package com.kh.spring08.controller;

import java.text.DecimalFormat;
import java.text.Format;
import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/jsp")
public class JspController {
	//화면에 전달해야할 데이터가 있다면 모델(Model)을 매개변수에 선언하고 데이터 추가
	@RequestMapping("/test01")
	public String test01(Model model) {
		//model에 원하는 데이터를 "이름을 붙여서" 전달
		//model.attrubute("이름", 값); (String, Object) ?? 자바의 맵하고 유사
		model.addAttribute("message", "Hello MVC Pattern!");
		Random r = new Random();
		int dice = r.nextInt(6) + 1;
		model.addAttribute("dice", dice);
		int lotto = r.nextInt(45) + 1;
		model.addAttribute("lotto", lotto);
		return "/WEB-INF/views/jsp/test01.jsp";
	}
	
	@RequestMapping("/test02")
	public String test02(Model model, @RequestParam String birth) {
		LocalDate b = LocalDate.parse(birth);
		LocalDate c = LocalDate.now();
		Period period = Period.between(b, c);
		int globalAge = period.getYears();
		int koreanAge = c.getYear() - b.getYear() + 1;
		
		model.addAttribute("globalAge", globalAge);
		model.addAttribute("koreanAge", koreanAge);
		return "/WEB-INF/views/jsp/test02.jsp";
	}
	
	@RequestMapping("/test03")
	public String test03(Model model, @RequestParam(required = false) long krw) {
//		Format f = new DecimalFormat("#,##0.##");
//		double usd = (double)krw * 0.00068;
//		double yen = (double)krw * 0.11;
//		double cny = (double)krw * 0.11;
//		model.addAttribute("dollar", f.format(usd));
//		model.addAttribute("yen", f.format(yen));
		
		double exchangeToUsd = 0.00067;
		double exchangeToCny = 0.00465;
		double exchangeToJpy = 0.106;
		
		model.addAttribute("usd", krw*exchangeToUsd);
		model.addAttribute("cny", krw*exchangeToCny);
		model.addAttribute("jpy", krw*exchangeToJpy);
		return "/WEB-INF/views/jsp/test03.jsp";
	}
}
