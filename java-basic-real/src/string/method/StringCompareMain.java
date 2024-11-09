package string.method;

public class StringCompareMain {
    public static void main(String[] args) {
        String str1 = "Hello Java";
        String str2 = "hello java";
        String str3= "Hello world";
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
        System.out.println("=========================");
        System.out.println("b".compareTo("a"));  // 사전적 비교 앞이엤는 문자열을 기준으로 왼쪽에 있으면 - // 오른쪽에있으면 +
        System.out.println("a".compareTo("c"));
        System.out.println("===========================");
        System.out.println(str1.compareToIgnoreCase(str2));
        System.out.println(str1.startsWith("Hello"));
        System.out.println(str1.endsWith("World"));

        System.out.println("=============================");

    }
}
