
public class Fourth {
	public static void main(String[] args) {
			
		
		int a =0b1010;  // 2진수
		System.out.println(a);
		
		int b = 0xef; // 1110 1111 16진수를 나타냄
		System.out.println(b);
		
		int c =1_234_567_890;
		System.out.println(c);
		System.out.println("=====================");
		// 왜 0.3이 아닐까?? => 10진수 0.2를 2진수로 변환하는 과정에서 오차 발새앟ㅁ
		System.out.println(0.1+0.2);
		// 실제로 값이 같지 않기 때문에 굉장히 위험한 방식의 연산이다
		System.out.println((0.1+0.2)==0.3);
		
		// System.out.println(10/0);
		System.out.println(0.1/0); // 무한대 (infinity)
		System.out.println(-0.1/0); // - 무한대 (infinity)
		byte b1 =(byte)(127+1);
		System.out.println(b1);
		byte b2 = 1; // 초기화 또는 대입할 때에는 int형을 byte에 대입이 가능하다
		b2=(byte)(b2+2); // 연산자가 여러개 1):byte 하고 int 연산을 시도 => 타입이 안맞음
		System.out.println(b2);
		// (int)+ int => 결과는 int
		// 2) =: 대입을 시도=> int의 타입을  byte에 넣으려는 시도로 인식 ==> 오류 

	}
}
