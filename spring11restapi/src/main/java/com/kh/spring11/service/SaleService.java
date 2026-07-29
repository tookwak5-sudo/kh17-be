package com.kh.spring11.service;

import java.io.IOException;

import com.kh.spring11.vo.sale.SaleAddRequestVO;
import com.kh.spring11.vo.sale.SaleAddResponseVO;

public interface SaleService {
	SaleAddResponseVO add(SaleAddRequestVO request) throws IllegalStateException, IOException;
}
