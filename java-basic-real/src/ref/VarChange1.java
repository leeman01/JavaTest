package ref;

public class VarChange1 {
    public static void main(String[] args) {
        int a=10;
        int b=a;
        System.out.println("a= " + a);
        System.out.println("b=" + b);
        // b는 a의 값만 복사한것이다 변수 a자체를 대입한것이 아니다
        a=20;
        System.out.println("a= " + a);
        System.out.println("b= " + b);

        b=30;
        System.out.println("a= " + a);
        System.out.println("b= " + b);
    }
}
