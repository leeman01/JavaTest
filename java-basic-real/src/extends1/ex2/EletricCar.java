package extends1.ex2;

public class EletricCar extends Car {  // extend =  -> 화살표
    // 자식은 상속받을 부모명을 알지만 부모는 자식에 대해서 전혀모른다

    public void charge(){
        System.out.println("차를 충전합니당");
    }
}
