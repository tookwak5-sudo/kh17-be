package jdbc.program;

import jdbc.dao.ProductDao;
import jdbc.dto.ProductDto;

public class Test14상품정보등록 {
	public static void main(String[] args) {
		//입력
		ProductDto productDto = new ProductDto();
		productDto.setProductName("풍선세트");
		productDto.setProductCategory("이벤트");
		productDto.setProductPrice(5000L);
		productDto.setProductStock(100L);
		productDto.setProductDiscount(0);
		productDto.setProductEarly("Y");
		//처리
		ProductDao productDao = new ProductDao();
		productDao.insert(productDto);
		
		//출력
		System.out.println("등록이 완료되었습니다");
	}
}
