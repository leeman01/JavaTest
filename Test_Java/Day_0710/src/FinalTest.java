/*
 * static 키워드
 * 클래스 변수 선언시사용
 * 클래스 변수는 객체의 생성없이 접근 가능
 * 
 * 멤버변수 앞
 * 멤버 메소드 앞
 * 내부 클래스 앞에 static 키워드를 붙여 클래스 변수 메소드 static 클래스로 작성하여 사용
 * 
 * final 키워드
 * 지역벼수 앞 - 값 수정 불가 , 선언하면서 값을 초기화해야 한다
 * 멤버변수 앞 -값 수정 불가 , 선언하면서 값을 초기화해야 한다
 * 멤버 메소드 앞 - 오버라이딩 불가
 * 클래스 앞 - 상속 불가
 */
public class FinalTest {


	String str1; // 멤버변수
	static String str2; // 클래스변수
	final String str3 = "강"; // 지역변수
	static final String MY_DATA = "데이터"; // static final가 붙어잇으면 상수변수로 절대로 변경이 안된다 ( 변수명 모두 대문자 ,_ 사용)

	public static void main(String[] args) {
		int a;
		a=10;
		final int b=10; // 이때 final 후 한번만 초기화 할수 있다 , 대입(다른 값 넣기)은 불가능하다
		
		System.out.println(a);
		System.out.println(FinalTest.str2);
		System.out.println(b);
		
	}
	

}
