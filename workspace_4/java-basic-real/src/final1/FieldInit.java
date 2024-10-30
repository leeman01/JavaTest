package final1;

public class FieldInit {
    static final int CONST_VALUE=10;
    final int value=10;

    public FieldInit() {
        // final에 값이 들어가면 생성자를 통해서도 값을 만들 수 없다
//        this.value = value;
    }
}
