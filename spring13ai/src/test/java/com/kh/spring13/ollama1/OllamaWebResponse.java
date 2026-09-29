package com.kh.spring13.ollama1;

public record OllamaWebResponse (
		String model,
		String created_at,
		String response,
		Long totalDuration
) {

}
