package string.equals;

public class StringEquslsMain2 {
    public static void main(String[] args) {
        String str = new String("HELLO"); // x001
        String str2 = new String("HELLO"); // x002
        System.out.println("두값이 같음? : " + (str == str2));
        System.out.println("두값이 같음? : " + (str.equals(str2)));
        System.out.println("결과: " + isSame(str, str2));

        String str3= "hello";
        String str4= "hello";
        System.out.println("결과: " + isSame(str3, str4));

    }
    private static boolean isSame(String x,String y){
//        return x==y;
        return x.equals(y);
    }

}
