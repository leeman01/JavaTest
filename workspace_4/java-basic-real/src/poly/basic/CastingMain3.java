package poly.basic;
// upcasting vs downcasting
public class CastingMain3 {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent1 = (Parent)child; // upcating은 (Parent) 생략권장/가능
        Parent parent2= child; // upcating 생략

        parent1.parentMethod();
        parent2.parentMethod();
    }
}
