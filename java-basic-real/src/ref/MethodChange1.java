package ref;

public class MethodChange1 {
    public static void main(String[] args) {
        int a=10;
        System.out.println(a);
        changePrime(a);
        System.out.println(a);
    }

    // 여기서는 x값이 a값을 복사해서 대입하는 것이다 a를 넣는 것이아니다!
    // 즉 x는 a의 값 10을 복사해서 x=10이 된것이고ㅡ > x=20값으로 변경된다 고로 a값에는 아무런 영햐도 미치지 못한다
    // 메서드가 종료되면 변수 x는 제거가된다
    static void changePrime( int x){
         x=20;
    }
}
