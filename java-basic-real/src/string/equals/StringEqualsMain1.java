package string.equals;

public class StringEqualsMain1 {
    public static void main(String[] args) {
        String str = new String("HELLO"); // x001
        String str2 = new String("HELLO"); // x002
        System.out.println("두값이 같음? : " + (str == str2));
        System.out.println("두값이 같음? : " + (str.equals(str2)));

        String str3= "hello";
        String str4 = "hello";
        System.out.println("리터럴 == 비교" + (str3==str4));
        System.out.println("리터럴 == 비교" + (str3.equals(str4)));
    }


}
