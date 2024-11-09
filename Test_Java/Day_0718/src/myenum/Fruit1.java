package myenum;

public enum Fruit1 {
	바나나("banana") , 딸기("strawberry") ,사과("apple") ;
	private String Fruit;
	Fruit1(String Fruit){  // 생성자는 꼭 있어야한다
		this.Fruit = Fruit;
		System.out.println("매칭단어: " + this.Fruit);
	}
	public String getFruit() {
		return Fruit;
	}
	public void setFruit(String fruit) {
		Fruit = fruit;
	}
}
