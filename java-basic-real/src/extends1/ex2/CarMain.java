package extends1.ex2;



public class CarMain {
    public static void main(String[] args) {
       EletricCar eletricCar = new EletricCar();
        eletricCar.move();
        eletricCar.charge();

        GasCar gasCar = new GasCar();
        gasCar.move();
        gasCar.charge();
    }
}
