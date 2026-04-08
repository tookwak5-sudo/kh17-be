package jdbc.program;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.List;

import jdbc.dao.ProductDao;
import jdbc.dto.ProductDto;

public class Test16상품정보조회검색 {
	public static void main(String[] args) {
		//입력
		String column = "product_name";
		String keyword = "초코";
		//처리
		ProductDao productDao = new ProductDao();
		List<ProductDto> list = productDao.selectList(column, keyword);
		
		//출력
		if(list.isEmpty()) {
			System.out.println("결과가 존재하지 않습니다.");
		}
		else {
			System.out.println("상품 종류 : " + list.size() + "개");
			Format f = new DecimalFormat("#,##0.##");
			for(ProductDto productDto : list) {
				System.out.print("상품 이름 :" + productDto.getProductName());
				System.out.print(" / ");
				System.out.print("카테고리 :" + productDto.getProductCategory());
				System.out.print(" / ");
				System.out.print("상품 가격 :" +f.format(productDto.getProductPrice()));
				System.out.print(" / ");
				System.out.print("상품 재고 :" + productDto.getProductStock());
				System.out.print(" / ");
				System.out.print("할인율 :" + productDto.getProductDiscount());
				System.out.print(" / ");
				System.out.print("실제 가격 : " + f.format(productDto.getAfterDiscount()) + "원");
				System.out.print(" / ");
			}
		}
			
	}
}
