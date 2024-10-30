package vo;

public class Foundation extends Product {
	
	
	private String texture;
	// 생성자 만들기
	
	public Foundation() {
		super();
	}
	public Foundation(String productno,String name, int price,String texture) {
		super(productno,name,price);
		this.texture = texture;
	}
	// getter setter 만들기
	public String getTexture() {
		return texture;
	}
	public void setTexture(String texture) {
		this.texture = texture;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "상품명 : " + this.getName() + "상품번호: " + this.getProductno() + 
				"상품 가격: "+ this.getPrice()+ "타입: " + texture  ;
	}
	
}
