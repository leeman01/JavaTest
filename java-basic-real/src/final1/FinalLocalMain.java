package final1;

public class FinalLocalMain {
    public static void main(String[] args) {
        // 파이널 지역변수
        final int data1;
        data1=10; // 최초한번만 할당 가능

//        data1=20;  이후에 다시 설정하려하면 오류발생
//         final 지역변수2
        final int data2 = 10;

//        data2=20;컴파일오류
    }
    static void method(final int parameter){
//        parameter=20; 값이 더이상 바뀔수없다 지역변수역시  매서드 내부에서 매개변수의 값 변경 x

    }

}
