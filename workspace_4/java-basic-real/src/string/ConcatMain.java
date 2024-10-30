package string;

public class ConcatMain {
    public static void main(String[] args) {
        String a="hello"; // x001v String은 객체타입으로 참조형 자료 타입이다 원래대로라면 참조형은 더하기가 가능하지 않다
        String b="world"; // x002 그러나 문자열은 너무 자주 다뤄서 특별히 + 연산을 허용한다 String 객체만 이를 허용한다
        String result1 = a.concat(b);
        String result2 = a+b;
        System.out.println(result1);
        System.out.println(result2);
    }
}
