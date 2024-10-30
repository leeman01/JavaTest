package string.method;

import java.sql.SQLOutput;

public class StringUtilsMain1 {
    public static void main(String[] args) {
        int num=100;
        boolean bool = true;
        Object obj = new Object();
        String str= "Hello Java!";

        // valueOf 메서드
        String numString = String.valueOf(num);
        System.out.println("숫자의 문자열 값: " + numString);
        boolean boolString = true;
        System.out.println("boolean의 문자열: " + String.valueOf(bool));
        System.out.println(String.valueOf(obj));

        String numString2 = "" + num ; // 문자 + 무언가 => 문자
        System.out.println("빈문자열  + num " + numString2);

        // toCharArray
        char[] strArry = str.toCharArray();
        System.out.println(strArry);
    }
}
