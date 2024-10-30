package ref;

public class VarChange2 {
    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        Data dataB= dataA;

        System.out.println("dataA의 참조값: " + dataA);
        System.out.println("dataB의 참조값: " + dataB);

        System.out.println(dataA.value);
        System.out.println(dataB.value);

        dataA.value=20;
        // 동일한 인스턴스에 접근햇으니까? 당연히 값이 똑같겟자
        // 참조변수의 복사하는 경우 변수에들어잇는 주소(참조값)을 복사한것이므로 동일한 건물로 이동하는 주소를 복사한것이다
        // 동일한 주소의 멤버변수를 바꾸면  동일한 건물로 도착하니 값도 똑같다
        System.out.println(dataA.value);
        System.out.println(dataB.value);
        dataB.value=40;
        System.out.println(dataB.value);
        System.out.println(dataA.value );


    }
}
