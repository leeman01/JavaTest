package inherit01;

public class Sedan extends Vehicle {
	

	
	boolean istrunck;
	
	// 생성자 생성
	public Sedan() {
		super();
	}
	public Sedan(boolean istrunck) {
		super();
		this.istrunck = istrunck;
	}
	public Sedan(boolean istrunck,int numberOfWheel, int numberOfSeat, double weight) {
		super(numberOfWheel, numberOfSeat, weight);
		this.istrunck = istrunck;
	}
	public boolean isIstrunck() {
		return istrunck;
	}
	public void setIstrunck(boolean istrunck) {
		this.istrunck = istrunck;
	}
	
	public void outputSedan() {
		this.output();
		if (istrunck == false) {
			System.out.println("트렁크 없음");
		}
		System.out.println("트렁크있음");
	}
	
	
}
