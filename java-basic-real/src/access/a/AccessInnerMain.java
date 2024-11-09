package access.a;

public class AccessInnerMain {
    public static void main(String[] args) {
        AccessData data = new AccessData();

        //public
        data.publicField=1;
        data.publicMethod();
        //같은 패키지 디폴트
        data.defaultField = 2;
        data.defaultMethod();
//        data.privateMethod();
        data.innerAccess();
        // private 값 불가
//        data.privateField=3; // 안된다
    }
}
