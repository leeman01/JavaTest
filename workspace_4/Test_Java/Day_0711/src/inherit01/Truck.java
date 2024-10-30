// public , protected 멤버만 상속
// private은 상속되지 않음 단 상속받은 public 메소드인 setter , getter를 통해서 
// 부모의 private한 멤버에 접근가능
// 생성자도 상속이 안됨
// 
package inherit01;

public class Truck extends Vehicle {
	
	private int maxLoad;
	
	// 생성자 만듦
	public Truck() { //
		super();
	}
	
	public Truck(int maxLoad) { //
		super();
		this.maxLoad=maxLoad;
	}
	

	public Truck(int maxLoad , int numberOfWheel,int numberOfSeat,double weight) {
		super(numberOfWheel,numberOfSeat,weight); // super는 위에 있어야한다  생성은 부모 -> 자식 순이다
		this.maxLoad = maxLoad;
	}

	// setter , getter ,output()  = > 부모한테 받는것은  super 로 받을수있음
	// 생성은 부모 자식 순으로 생기고 소멸은 자식 , 부모순으로 없어짐
	
	public int getMaxLoad() {
		return maxLoad;
	}

	public void setMaxLoad(int maxLoad) {
		this.maxLoad = maxLoad;
	}
	public void outputTruck() {
		this.output();
		System.out.println("Truck="+maxLoad);
	}
	
}
