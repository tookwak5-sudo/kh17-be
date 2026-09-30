package com.kh.spring13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring13.service.OllamaService;
import com.kh.spring13.vo.CustomChatRequestVO;
import com.kh.spring13.vo.CustomChatResponseVO;


@CrossOrigin
@RestController
@RequestMapping("/api/ai")
public class OllamaRestController {
	@Autowired
	private OllamaService ollamaService;
	
	@PostMapping("/professor")
	public String professor(@RequestBody String prompt) {
		return ollamaService.askToProfessor(prompt);
	}
	@PostMapping("/grandpa")
	public String grandpa(@RequestBody String prompt) {
		return ollamaService.askToGrandpa(prompt);
	}
	@PostMapping("/children")
	public String children(@RequestBody String prompt) {
		return ollamaService.askToChildren(prompt);
	}
	
	@PostMapping("/chat")
	public CustomChatResponseVO chat(@RequestBody CustomChatRequestVO request) {
		return ollamaService.ask(request);
	}
}
