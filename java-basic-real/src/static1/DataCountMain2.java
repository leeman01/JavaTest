package static1;

public class DataCountMain2 {
    public static void main(String[] args) {
        COunter counter = new COunter();
        Data2 data1 = new Data2("A",counter);
        System.out.println(counter.count);

        Data2 data2 = new Data2("B",counter);
        System.out.println(counter.count);

        Data2 data3 = new Data2("C",counter);
        System.out.println(counter.count);
    }
}
