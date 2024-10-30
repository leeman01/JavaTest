package poly.ex4.ex3;

public class AbstractMain {
    public static void main(String[] args) {
        // 추상클래스 생성불가
//        AbstractAnimal a = new AbstractAnimal() ; 생성안됨
        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();

        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(cow);

        moveAnimal(dog);
        moveAnimal(cat);
        moveAnimal(cow);
    }
    private static void soundAnimal(AbstractAnimal animal){
        System.out.println("테스트시작");
        animal.sound();
        System.out.println("종료");
    }
    private static void moveAnimal(AbstractAnimal animal){
        System.out.println("테스트시작");
        animal.move();
        System.out.println("종료");
    }
}
