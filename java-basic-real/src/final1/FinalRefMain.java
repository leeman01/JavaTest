package final1;

public class FinalRefMain {
    public static void main(String[] args) {

        final Data1 data = new Data1();
//        data = new Data(); 이미 참조값이 들어잇어서 새로운 주소를 줄수 없다

        // 참조대상의 값은 변경이가능
        data.value=10;
        System.out.println(data.value);
        data.value = 20 ;
        System.out.println(data.value);
    }
}
