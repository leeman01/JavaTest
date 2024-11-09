package access.a;

public class AccessData {
    public int publicField;
    int defaultField;
    private int privateField;

    public void publicMethod(){
        System.out.println(publicField);
    }
    private void privateMethod(){
        System.out.println(privateField);
    }
    void defaultMethod(){
        System.out.println(defaultField);
    }
    public void innerAccess(){
        System.out.println("내부호출");
        publicField=100;
        privateField=200;
        defaultField=300;
        publicMethod();
        defaultMethod();
        privateMethod();
    }
}
