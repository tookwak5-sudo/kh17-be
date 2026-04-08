package jdbc.program;

import jdbc.dao.ProductDao;
import jdbc.dto.ProductDto;

public class Test15상품정보수정 {
	public static void main(String[] args) {
		//입력
		ProductDto productDto = new ProductDto();
		productDto.setProductNo(21);
		productDto.setProductName("초코빵");
		productDto.setProductCategory("제과");
		productDto.setProductPrice(10000L);
		productDto.setProductStock(100L);
		productDto.setProductDiscount(30);
		productDto.setProductEarly("N");
		//처리
		ProductDao productDao = new ProductDao();
		boolean success = productDao.update(productDto);
		
		//출력
		if(success) {
			System.out.println("입력하신 상품이 수정되었습니다.");
		}
		else {
			System.out.println("등록된 상품이 없습니다.");
		}
	}
}
