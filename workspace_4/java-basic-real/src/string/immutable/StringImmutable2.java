package string.immutable;

public class StringImmutable2 {
    public static void main(String[] args) {
        String str= "hello";
        String str2 = str.concat(" java");
        System.out.println(str);
        System.out.println(str2); // 핵심은 스트링은 불변이라는 것이다
    }
}
