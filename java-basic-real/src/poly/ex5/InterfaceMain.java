package poly.ex5;



public class InterfaceMain {
    public static void main(String[] args) {
        Dog dpg = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();

        soundAnimal(cat);
    }
    private static void soundAnimal(InterfaceAnimal animal){
        System.out.println("테스트시작");
        animal.sound();
        System.out.println("종료");
    }
}
