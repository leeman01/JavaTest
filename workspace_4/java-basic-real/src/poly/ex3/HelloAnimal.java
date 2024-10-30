package poly.ex3;

public class HelloAnimal extends AbstractAnimal{
    @Override
    public void sound() {
        System.out.println("반드시 오버라이딩 해야됨" );
    }
}
