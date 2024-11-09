package extends1.access.child;

import extends1.access.parent.Parent;

public class Child extends Parent {
    public void call(){
        publicValue=1;
        protectedValue=1;
//        defaultvalue=1; 다른 패키지라서 컴파일 오류
//        privateValue=1;
        publicMethod();
        protectedMethod();// 상속받아서 다른 패키지라도 사용 가능
//        defaultMethod();
//        privateMethod();
        print(); // public
    }
}
