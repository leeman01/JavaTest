package ref;

public class NullMain3 {
    public static void main(String[] args) {
        BigData bigdata = new BigData();
        System.out.println(bigdata.count); // 0
        System.out.println(bigdata.data); // null
        // 여기서 NullPointerException 발생
        System.out.println(bigdata.data.value);
    }
}
