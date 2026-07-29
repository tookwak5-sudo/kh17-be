package com.kh.spring11.sale;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring11.service.SaleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test01프로파일구분 {
	@Autowired
	private SaleService saleService;
	
	@Test
	public void test() throws IllegalStateException, IOException {
		saleService.add(null);
	}
}
