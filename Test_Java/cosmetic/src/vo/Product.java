package vo;

public class Product  {
	private String productno;
	private String name;
	private int price;
	// 생성자 만들기
	public Product() {
		super();
	}
	public Product(String productno, String name, int price) {
		super();
		this.productno = productno;
		this.name = name;
		this.price = price;
	}
	// gettetr setter 처리
	public String getProductno() {
		return productno;
	}
	public void setProductno(String productno) {
		this.productno = productno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "상품명 : " + name + "상품번호: " + productno + "상품 가격: "+ price;
	}
	
}
