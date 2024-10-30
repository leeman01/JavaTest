package static1;

public class DataMainCount1 {
    public static void main(String[] args) {
        // 참조값 복사가 아닌 새롭게 생성한 것이니 다 1 1 1 이 나온다
        Data1 data1= new Data1("A");
        System.out.println("A count: " + data1.count);

        Data1 data2 = new Data1("B");
        System.out.println("B count: " + data2.count);

        Data1 data3 = new Data1("C");
        System.out.println("C count: " + data3.count);
    }
}
