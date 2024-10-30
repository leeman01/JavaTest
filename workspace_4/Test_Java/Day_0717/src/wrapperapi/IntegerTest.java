package wrapperapi;

public class IntegerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i1 = 2147483647; // private int데이터 45가  integer로 wrapping 된다
		i1 +=1;
//		System.out.println(i1);
//		System.out.println(Integer.BYTES); // 인티저의 저장용량
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Integer.MIN_VALUE);
//		System.out.println(Integer.SIZE); // 4바이트를 비트로 바꾸면 32비트
		
		int tmp = i1.bitCount(12);
		// 정수값이 메모리에 저장되었을 때 1의 개수
		System.out.println(tmp);
		System.out.println(Integer.bitCount(3));    // 0000  0011
		System.out.println(Integer.bitCount(10));// 0000 1010 1의 개수를 세는것
		System.out.println(Integer.bitCount(-1)); 
		// 첫번째 전달인자: 숫자로 구문분석 가능한 문자열
		// 두번째 전잘인자 : 첫번째 문자열이 몇진수인지
		// 메소드는 숫자를 10진수로 변환하는 메소드
		String str = "12";
		int i2 = Integer.parseInt(str); // 문자열 데이터를 정수로 변환할 수 있도록 구문분석하는 메소드
		System.out.println(i2*7);
		
		Integer i3 = Integer.parseInt(str,16); // 16진수 수인 12 => 10진수 숫자로 바꿔 == 18
		System.out.println(i3);
		
	}

}
