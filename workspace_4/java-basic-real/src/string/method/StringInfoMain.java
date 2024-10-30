package string.method;

public class StringInfoMain {
    public static void main(String[] args) {
        String str = "Hello JAVA";
        System.out.println(str.length());
        System.out.println(str.isEmpty());
        System.out.println(str.isBlank());
        System.out.println("         ".isBlank());
        System.out.println("       ".isEmpty());

        System.out.println(str.charAt(7));
    }
}
