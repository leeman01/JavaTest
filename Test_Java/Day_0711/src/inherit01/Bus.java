package inherit01;

public class Bus extends Vehicle{
	
	

	private String busNumber;
	// 생성자
	
	
	public Bus() {
		super();
	}
	
	public Bus(String busNumber) {
		super();
		this.busNumber = busNumber;
	}
	// 상속 받음
	public Bus(String busNumber,int numberOfWheel, int numberOfSeat, double weight) {
		super(numberOfWheel, numberOfSeat, weight);
		this.busNumber = busNumber;
		// TODO Auto-generated constructor stub
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public void outputBus() {
		this.output();
		System.out.println("Bus Number =" + this.busNumber);
	}

	
}
