package extends1.super2;

public class ClassB extends ClassA{
    public ClassB(int a){
        super(); //기본생성자 생략
        System.out.println("classB생성자 a= " + a);
    }
    public ClassB(int a,int b){
        super();
        System.out.println("class B의 생성자  a= " + a +"b = " + b);
    }
}
