package poly.basic;

public class PolyMain {
    public static void main(String[] args) {
        System.out.println("Parent -> Parent");
        Parent parent = new Parent();
        parent.parentMethod();

        // 자식변수가 자식 인스턴스 참조
        Child child = new Child();
        child.parentMethod();
        child.childMethod();
    // 부모 인스턴스가 자식 인스턴스 참조
        System.out.println("parent=>child");
        Parent poly = new Child();
        poly.parentMethod();

//        Child child1 = new Parent(); 자식은 부모를 담을 수 없다
//        poly.childMethod(); 자식의 기능은 호출 할 수없다
        System.out.println("Parent 타입 변경");
        // 다운캐스팅 (부모타입=>자식타입)
        Child child1 = (Child) poly; // poly 값이 child로 변경되는 것이아니다
        child1.childMethod();
        child1.parentMethod();
    }
}
