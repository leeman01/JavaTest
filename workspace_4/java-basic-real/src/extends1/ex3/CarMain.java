package extends1.ex3;


public class CarMain {
    public static void main(String[] args) {
       EletricCar eletricCar = new EletricCar();
        eletricCar.move();
        eletricCar.charge();
        eletricCar.openDoor();

        GasCar gasCar = new GasCar();
        gasCar.move();
        gasCar.charge();
        gasCar.openDoor();

        HydroCar hydroCar = new HydroCar();
        hydroCar.openDoor();
        hydroCar.move();
        hydroCar.hydroCharge();
    }
}
