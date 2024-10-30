package inherit01;

public class Vehicle {
	private int numberOfWheel;
	private int numberOfSeat;
	private double weight;
	
	public Vehicle() {
		super();
	}
	public Vehicle(int numberOfWheel, int numberOfSeat, double weight) {
		super();
		this.numberOfWheel = numberOfWheel;
		this.numberOfSeat = numberOfSeat;
		this.weight = weight;
	}
	public int getNumberOfWheel() {
		return numberOfWheel;
	}
	public void setNumberOfWheel(int numberOfWheel) {
		this.numberOfWheel = numberOfWheel;
	}
	public int getNumberOfSeat() {
		return numberOfSeat;
	}
	public void setNumberOfSeat(int numberOfSeat) {
		this.numberOfSeat = numberOfSeat;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public void output() {
		System.out.println("vehivle:"+numberOfWheel + "," + numberOfSeat + "," + weight);
	}
}

