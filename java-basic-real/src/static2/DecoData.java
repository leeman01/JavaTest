package static2;

public class DecoData {
    private int instanceValue;
    private static int staticvalue;

    public static void staticCall(){
//        instanceValue++;  정적 메서드(클래스)에서 인스턴스 영역은 참고할 수 없다
//        instanceMethod();
        staticvalue++; // 정적변수 접근
        staticMethod(); // 정적 메서드 접근 가능
    }
    public void instanceCall(){ // 인스턴스영역에서는 모든곳에 접근이 가능하다
        instanceValue++;
        instanceMethod();

        staticvalue++;
        staticMethod();
    }
    private void instanceMethod(){
        System.out.println("instance: " + instanceValue);

    }
    private static void staticMethod(){
        System.out.println("static: " + staticvalue);
    }

    // 참조할 data값을 만들어서 인스턴스 영역에 접근이 가능하다
    public static void staticCall(DecoData data){
        data.instanceValue++;
        data.instanceMethod();
    }
}
