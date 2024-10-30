package ref;

public class NullMain4 {
    public static void main(String[] args) {
        BigData bigdata = new BigData();
        bigdata.data = new Data(); // BigData 의 data 값에 참조값을 설정한다
        System.out.println(bigdata.count);
        System.out.println(bigdata.data);
        System.out.println(bigdata.data.value);
    }
}
