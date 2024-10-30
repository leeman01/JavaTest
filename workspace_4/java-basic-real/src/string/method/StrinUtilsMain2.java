package string.method;

public class StrinUtilsMain2 {
    public static void main(String[] args) {
        int num=100;
        boolean bool =true;
        String str  = "Hello World";
        // format 메서드
        String str1 = String.format("num: %d , bool: %b , str: %s", num, bool, str);
        System.out.println(str1);

        String format2 = String.format("숫자: %.2f",10.1234);
        System.out.println(format2);

        //printf
        System.out.printf("숫자: %.2f",10.1234);

        // matches 메서드
        String regex = "Hello (Java!|World)";
        System.out.println("str이 패턴과 일치하는가"+ str.matches(regex));
    }
}
