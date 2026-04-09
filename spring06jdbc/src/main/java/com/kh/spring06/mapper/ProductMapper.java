package com.kh.spring06.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring06.dto.ProductDto;

@Component
public class ProductMapper implements RowMapper<ProductDto>{

	@Override
	public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductDto productDto = new ProductDto();
		productDto.setProductNo(rs.getInt("product_no"));
		productDto.setProductName(rs.getString("product_name"));
		productDto.setProductCategory(rs.getString("product_category"));
		productDto.setProductPrice(rs.getLong("product_price"));
		productDto.setProductStock(rs.getLong("product_stock"));
		productDto.setProductDiscount(rs.getInt("product_discount"));
		productDto.setProductEarly(rs.getString("product_early"));
		return productDto;
	}
	
}
