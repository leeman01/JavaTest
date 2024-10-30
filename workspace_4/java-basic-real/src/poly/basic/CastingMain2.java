package poly.basic;

public class CastingMain2 {
    public static void main(String[] args) {
        Parent poly = new Child();
        Child child1 = (Child) poly;

        // 일시적 다운캐스팅 - 해당메서드를 호출하는 순간만 다운캐스칭
        ((Child) poly).childMethod();
    }
}
