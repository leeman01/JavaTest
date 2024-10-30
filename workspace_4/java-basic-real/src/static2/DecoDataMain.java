package static2;

public class DecoDataMain {
    public static void main(String[] args) {
        System.out.println("1.정적호출");
        DecoData.staticCall();

        System.out.println("2.인스턴스 호출");
        DecoData data = new DecoData();
        data.instanceCall();

        System.out.println("3.인스턴스 호출");
        DecoData data2 = new DecoData();
        data2.instanceCall();

        DecoData.staticCall(data2);
    }
}
