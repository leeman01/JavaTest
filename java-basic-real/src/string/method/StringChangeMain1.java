package string.method;

public class StringChangeMain1 {
    public static void main(String[] args) {
        String str = "Hello Java World Welcome to Java World";
        System.out.println("인덱스 7부터의 부분 문자열: " + str.substring(7));
        System.out.println("7~12 까지의 부분문자열: " + str.substring(7, 12));

        System.out.println(str.concat("!!!"));
        System.out.println("Java를 World로 변경: " + str.replace("Java", "World"));
        System.out.println("첫번째 자바만 월드로 대체: " + str.replaceFirst("Java", "World"));
    }

}
