package inherit01;

public class VehicleMain {

	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle(4,4,500.5);
		vehicle.output();
		
		Truck truck = new Truck(10);
		truck.outputTruck();
		truck.output();
		
		Truck truck2 = new Truck(15,6,8,15000);
		truck2.outputTruck();
//		truck2.output();
		
		Bus bus = new Bus( "15");
		bus.outputBus();
		
		Bus bus2 = new Bus( "150",4,25,20000);
		bus2.outputBus();
		
		Sedan sedan = new Sedan(true);
		sedan.outputSedan();
	}

}
