package com.kh.spring09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync//이제부터 이 프로그램에서는 비동기 시스템을 사용할거에요(한번만)
@EnableScheduling//이제부터 이 프로그램에서는 스케줄링 시스템을 사용할거에요(계속)
@SpringBootApplication
public class Springpt09integrateApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springpt09integrateApplication.class, args);
	}

}
