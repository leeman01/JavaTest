package poly.basic;
// 다운캐스팅을 자동으로 하지않는 이유
public class CastingMain6 {
    public static void main(String[] args) {
        Parent parent1 = new Parent();
        call(parent1);
        Parent parent2 = new Child();
        call(parent2);
    }
    private static void call(Parent parent){
//         Child 인스턴스인경우 childMethod 사용
        if(parent instanceof Child child){
            System.out.println("cild instance 맞음");
            child.childMethod();
        }else{
            System.out.println("Cild instance 아님");
        }
    }
}
