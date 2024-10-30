package poly.ex3;

public abstract class AbstractAnimal {
    public abstract void sound();

    public void move(){ // 자식에서 상속을하는 목적으로 만든 것 오버라이딩 필수가 아니다
        System.out.println("동물이 움직입니다");
    }
}
