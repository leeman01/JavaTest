
public class MethodTest_06 {

	public static void main(String[] args) {
		MethodTest_06 mt = new MethodTest_06(); // 멤버 메소드에 접근하기위한 방법
		mt.output(); // static에서는 non-static에 접근 불가

	}
	// non-static 메소드는 멤버 메소드라 부른다
	public void output() {
		System.out.println("output 메소드 입니다.");
	}
}
