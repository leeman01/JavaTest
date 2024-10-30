package string.method;

public class StringChangeMain2 {
    public static void main(String[] args) {
        String strSpace = "   Java Programming";
        System.out.println("소문자로변환: " + strSpace.toLowerCase());
        System.out.println(strSpace.toUpperCase());

        System.out.println("공백제거: " + strSpace.trim());
        System.out.println(strSpace.strip());
    }
}
