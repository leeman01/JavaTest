package string.builder;

public class StringBuilderMain1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("A");
        sb.append("B");
        sb.append("C");
        sb.append("D");
        System.out.println("sb= " +sb);

        sb.insert(4," JAVA");
        System.out.println("inserted sb= " +sb);

        sb.delete(4,8);
        System.out.println("deleted sb: "+sb);

        sb.reverse();
        System.out.println("reversed sb: "+sb);

        //String 변환
        String str= sb.toString();
        System.out.println("str= " +str);
    }
}
