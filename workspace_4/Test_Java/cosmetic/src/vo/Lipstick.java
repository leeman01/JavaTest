package vo;

public class Lipstick extends Product  {
	private String type;
	private String color;
	// 생성자 만들기
	public Lipstick() {
		super();
	}
	public Lipstick(String productno,String name, int price,String type, String color) {
		super(productno,name,price);
		this.type = type;
		this.color = color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "상품명 : " + this.getName() + "상품번호: " + this.getProductno() + 
				"상품 가격: "+ this.getPrice()+ "타입: " + type + "색상: " + color ;
	
	}
	
}
