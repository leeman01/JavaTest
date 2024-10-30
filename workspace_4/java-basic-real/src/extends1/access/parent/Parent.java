package extends1.access.parent;

public class Parent {
    public int publicValue;
    protected int protectedValue;
    int defaultValue;
    private int privateValue;

    public void publicMethod(){
        System.out.println("parent.publicMethod");
    }
    protected void protectedMethod(){
        System.out.println("parent.protectedMethod");
    }
    void defaultMethod(){
        System.out.println("parent.defaultMethod");
    }
    private void privateMethod(){
        System.out.println("Parent.privateMethod");
    }
    public void print(){
        System.out.println("parent 메서드안");
        System.out.println(publicValue);
        System.out.println(protectedValue);
        System.out.println(defaultValue);
        System.out.println(privateValue);
        // 부모메서드안에 접근 가능
        defaultMethod();
        privateMethod();
    }
}
