package string.immutable;

public class StringImmutable1 {
    public static void main(String[] args) {
        String str= "hello";
        str.concat(" java");
        System.out.println(str); // 문자가 합쳐지지않앗다 == > String 은 불변객체이다
    }
}
