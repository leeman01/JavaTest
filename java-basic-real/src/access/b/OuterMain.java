package access.b;

import access.a.AccessData;

public class OuterMain {
    public static void main(String[] args) {
        AccessData data = new AccessData();

        //public
        data.publicField=1;
        data.publicMethod();
//        //같은 패키지 디폴트
//        data.defaultField = 2;  ==> 다른 패키지라 호출불가
//        data.defaultMethod();

        data.innerAccess();
        // private 값 불가
//        data.privateField=3; // 안된다
    }
}
