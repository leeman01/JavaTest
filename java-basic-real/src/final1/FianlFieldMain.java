package final1;

public class FianlFieldMain {
    public static void main(String[] args) {
        System.out.println("생성자로 초기화");
        ConstructInit constructInit = new ConstructInit(10);
        ConstructInit constructInit2 = new ConstructInit(120);
        System.out.println(constructInit.value);
        System.out.println(constructInit2.value);
//         파이널 필드 - 필드초기화
        System.out.println("필드초기화");
        FieldInit fieldInit1 = new FieldInit();
        FieldInit fieldInit2 = new FieldInit();
        FieldInit fieldInit3 = new FieldInit();
        System.out.println(fieldInit1.value);

        System.out.println(fieldInit2.value);
        System.out.println(fieldInit3.value);

        // 상수
        System.out.println("상수");
        // 자바에서는 static final이 붙은 애를 상수라고 부른다
        System.out.println(FieldInit.CONST_VALUE);
    }
}
