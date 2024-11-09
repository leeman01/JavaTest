package poly.basic;
// 다운캐스팅을 자동으로 하지않는 이유
public class CastingMain5 {
    public static void main(String[] args) {
        Parent parent1 = new Parent();
        call(parent1);
        Parent parent2 = new Child();
        call(parent2);
    }
    private static void call(Parent parent){
        if(parent instanceof Child){
            System.out.println("cild instance 맞음");
            Child child = (Child)parent;
            child.childMethod();
        }else{
            System.out.println("Cild instance 아님");
        }
    }
}
