package final1;

public class ConstructInit {
    final int value;
    // 생성자를 통해서 값을 할당해야한다 이후에 값을 변경하는 것은 불가능하다 => 생성자를 통한 초기화만 가능
    public ConstructInit(int value) {
        this.value = value;
    }

}
