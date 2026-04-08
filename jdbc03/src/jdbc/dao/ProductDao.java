package jdbc.dao;

import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.ProductDto;
import jdbc.mapper.ProductMapper;
import jdbc.util.JdbcUtils;

public class ProductDao {
	private JdbcTemplate jdbcTemplate = JdbcUtils.create();
	private ProductMapper productMapper = new ProductMapper();
	private Set<String> columnList = Set.of("product_name", "product_category");
	
	//등록
	public void insert(ProductDto productDto) {
		String sql = "insert into product("
				+ "product_no, product_name, product_category, product_price, "
				+ "product_stock, product_discount, product_early) "
				+ "values(product_seq.nextval, ?, ?, ?, ?, ?, ?)";
		Object[] params = {
				productDto.getProductName(), productDto.getProductCategory(), productDto.getProductPrice(),
				productDto.getProductStock(), productDto.getProductDiscount(), productDto.getProductEarly()
		};
		jdbcTemplate.update(sql, params);
	}
	
	//수정
	public boolean update(ProductDto productDto) {
		String sql = "update product set "
				+ "product_name=?, "
				+ "product_category=?, "
				+ "product_price=?, "
				+ "product_stock=?, "
				+ "product_discount=?, "
				+ "product_early=? "
				+ "where product_no=?";
		Object[] params = {
				productDto.getProductName(), productDto.getProductCategory(), productDto.getProductPrice(),
				productDto.getProductStock(), productDto.getProductDiscount(), productDto.getProductEarly(),
				productDto.getProductNo()
		};
		return jdbcTemplate.update(sql, params) > 0;
	}
	
	//삭제
	public boolean delete(int productID) {
		String sql = "delete product where product_id=?";
		Object[] params = {productID};
		return jdbcTemplate.update(sql, params) > 0;
	}
	
	//조회
	public List<ProductDto> selectList() {
		String sql = "select * from product order by product_no asc";
		return	jdbcTemplate.query(sql, productMapper);
	}
	
	//검색
	public List<ProductDto> selectList(String column, String keyword){
		if(column == null || keyword == null) return selectList();
		if(column.isBlank() || keyword.isBlank()) return List.of();
		
		String sql = "select * from product where instr("+column+", ?) > 0 order by product_no asc";
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, productMapper, params);
	}
	
	//상세검색
	public ProductDto selectOne(int productNo){
		String sql = "select * from product where productNo=? order by asc";
		Object[] params = {productNo};
		List<ProductDto> list= jdbcTemplate.query(sql, productMapper, params);
		return list.isEmpty() ? null : list.get(0);
	}
}
