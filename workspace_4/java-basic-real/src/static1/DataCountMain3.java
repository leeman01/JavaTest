package static1;

public class DataCountMain3 {
    public static void main(String[] args) {

        Data3 data1 = new Data3("A");
        System.out.println("A: " + Data3.count);

        Data3 data2 = new Data3("B");
        System.out.println("B: " + Data3.count);

        Data3 data3 = new Data3("C");
        System.out.println("C: " + Data3.count);
        // 인스턴스를 통한 접근
        Data3 data4 = new Data3("D");
        System.out.println("D: " + data4.count); // 인스턴스를 통한 접근은 권장하지 않는다
        // 코드를 읽을 떄마다 마치 인스턴스변수에 접근하는 걸로 오해할 수 있기 때문이다

        // 클래스를 통한 접근
        System.out.println("D: " + Data3.count);
    }
}
