package extends1.overwriting;

public class EletricCar extends Car {  // extend =  -> 화살표
    // 자식은 상속받을 부모명을 알지만 부모는 자식에 대해서 전혀모른다

    public void charge(){
        System.out.println("차를 충전합니당");
    }
// 이 에노테이션이 없어도 정상작동 하지만  개발자는 무조건 사용한다 == > 만약에 오버라이딩하다가 문제가 생기면?
    // 이 에노테이션을 쓰면 오버라이딩 쓰면 컴파일 오류를 일으켜 오류를 잡기 쉽게 만든다
    @Override
    public void move() {
        System.out.println("전기차는 빠르게 이동합니당");
    }
}
