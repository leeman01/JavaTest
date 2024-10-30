package poly.ex4.ex3;

public class Cat extends AbstractAnimal {
    @Override
    public void sound() {
        System.out.println("야옹");
    }

    @Override
    public void move() {
        System.out.println("고양이이동");
    }
}
