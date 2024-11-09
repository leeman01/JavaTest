package string.builder;

public class StringBuilderMain2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String result = sb.append("A").append("B").append("C").append("Java Hello").insert(4,"JAVA").delete(4,7).reverse().toString();
        System.out.println(result);
    }
}
