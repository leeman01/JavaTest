package ref;

public class NullMain1 {
    public static void main(String[] args) {
        Data data = null;
        System.out.println("data1" + data);

        data = new Data();
        System.out.println("2.data:" + data);
        // 지금 data 주소값을 참조값으로 줫는데 null로 조회하게 함으로써 해당 인스턴스에 접근이 가능한 방법이 없다
        // 이렇게 아무도 사용하지 않는 인스턴스(객체)는 메모리 낭비가 된다 => 자동으로 삭제된다
        data=null;
        System.out.println("3.data:" + data);
    }

}
