package string.method;

public class StringSearchMain {
    public static void main(String[] args) {
        String str= "Hello Java! Welcome to Java World";

        System.out.println("java 문자 포함여부" + str.contains("Java"));
        System.out.println(str.indexOf("Java"));
        System.out.println(str.indexOf("Java",10));
        System.out.println("자바의 마지막 인덱스" + str.lastIndexOf("Java"));
    }
}
