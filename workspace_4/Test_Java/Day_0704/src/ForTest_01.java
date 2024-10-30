
public class ForTest_01 {

	public static void main(String[] args) {
		int i=1;
		for (; i<10;++i) {
			System.out.println(i);
		} // for문에서 벗어나는 순간 i 지역변수는 사라진다
		System.out.println(i); // for문 밖에서 실행된경우 지역변수로 사라지지 않는다

	}

}
