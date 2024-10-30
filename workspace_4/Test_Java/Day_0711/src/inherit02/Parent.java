package inherit02;

public class Parent {
	private int money;
	
	// 생성자 만들기 , 모든 클래스의 부모 ! Object
	public Parent() {
		super();
	}

	public Parent(int money) {
		super();
		this.money = money;
	}
	// getter , setter
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	//일반 메소드
	public int earning() {
		
		return this.money*2;
	}
	
	public void output() {
		System.out.println("부모의 현재 자산"+money
				+"투자수익:" + this.earning());
	}

}
