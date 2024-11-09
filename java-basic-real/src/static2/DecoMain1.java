package static2;

public class DecoMain1 {
    public static void main(String[] args) {
        String s = "hello java";
        DecoUtil utils = new DecoUtil();
        String deco = utils.deco(s);

        System.out.println(s);
        System.out.println(deco);
    }
}
