package jdbc.dto;

public class ProductDto {
	private int productNo;
	private String productName;
	private String productCategory;
	private Long productPrice;
	private Long productStock;
	private int productDiscount;
	private String productEarly; //새벽배송여부
	
	
	@Override
	public String toString() {
		return "ProductDto [productNo=" + productNo + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productPrice=" + productPrice + ", productStock=" + productStock
				+ ", productDiscount=" + productDiscount + ", productEarly=" + productEarly + ", afterDiscount()="
				+ getAfterDiscount() + "]";
	}

	//가상의 getter
	public double getAfterDiscount() {
		return productPrice / 100 * (100 - productDiscount);
	}
	
	public ProductDto() {
		super();
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public Long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Long productPrice) {
		this.productPrice = productPrice;
	}
	public Long getProductStock() {
		return productStock;
	}
	public void setProductStock(Long productStock) {
		this.productStock = productStock;
	}
	public int getProductDiscount() {
		return productDiscount;
	}
	public void setProductDiscount(int productDiscount) {
		this.productDiscount = productDiscount;
	}
	public String getProductEarly() {
		return productEarly;
	}
	public void setProductEarly(String productEarly) {
		this.productEarly = productEarly;
	}
}
