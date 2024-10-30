package poly.car0;

public class CarMain0 {
    public static void main(String[] args) {
        Driver driver = new Driver();
        K3Car car = new K3Car();

        driver.setK3Car(car);
        driver.drive();

        // 추가
        Model3Car model2 = new Model3Car();
        driver.setK3Car(null);
        driver.setModel3Car(model2);
        driver.drive();
    }
}
