package poly.overriding;

public class OverridingMain {
    public static void main(String[] args) {
        Child child = new Child();
        System.out.println("Child -> Child");
        System.out.println(child.value);
        child.method();

        // 변수가 부모인스턴스 참조
        Parent parent = new Parent();
        System.out.println("parent=>parent");
        System.out.println(parent.value);
        parent.method();

        // 부모 변수가 자식 인스턴스를 참조
        Parent poly = new Child();
        System.out.println("parent->Child");
        System.out.println(poly.value);
        // 변수는 오버라이딩 x  // 메소드는 오버라이딩 o
        poly.method();
    }
}
