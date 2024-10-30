package extends1.super2;

public class ClassC extends ClassB{
    public ClassC(){
        super(10,20); // 기본생성자가 없으면 직접 만들어야한다 // 호출을 해야함
        System.out.println("CLassC의 생성자");

    }
}
