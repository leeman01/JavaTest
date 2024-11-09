package memory;

public class JavaMemoryMain2 {
    public static void main(String[] args) {
        System.out.println("main start");
        method1();
        System.out.println("main end");

    }
    static void method1(){
        System.out.println("Main 1 start");
        Data data1 = new Data(10);
        method2(data1);
        System.out.println("main 1 end");
    }
    static void method2(Data data2){
        System.out.println("main2 start");
        System.out.println(data2.getValue());
        System.out.println("main 2 end");
    }
}
