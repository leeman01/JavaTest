package poly.ex2;

public class AnimalPolyMain2 {
    public static void main(String[] args) {
       Animal dog = new Dog();
       Animal cat = new Cat();
       Animal cow = new Cow();
       Animal[] animalArr = {new Dog(),new Cat(),new Cow()};

       for(Animal s : animalArr)
           s.sound();
    }




}
