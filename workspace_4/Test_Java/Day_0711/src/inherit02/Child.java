package inherit02;
// 다중 상속을 할수 없다
public class Child extends Parent {
	private int property;

	public Child() {
		super();
	}

	public Child(int property) {
		super();
		this.property = property;
	}

	public int getProperty() {
		return property;
	}

	public void setProperty(int property) {
		this.property = property;
	}
	public int gather() {
		return this.property *3;
	}
	public void output() {
		super.output();
		System.out.println("자식 현재 자산: "+ property
				+", 증식한 자산: " + gather() );
	}
}
