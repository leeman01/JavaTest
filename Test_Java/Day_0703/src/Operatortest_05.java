
public class Operatortest_05 {

	public static void main(String[] args) {
		byte a = 0b00001111; // 0000 1111
		byte b = 0x0f; // 0000 1111
		byte c =15 ; // 0000 1111
		System.out.println(a+","+b+","+c);
		
		int x = 3 ;  // 0000 0011 2+1 =3 
		int y=2; 	// 0000 0010 => 2
		int z;
		
		// & : 둘다 1일 때만 1임
		z = x & y;
		System.out.println("x & y=" + z);
		// | : 둘중 하나만 1이면 1
		z = x | y;
		System.out.println("x | y=" + z);
		
		// ^:배타적 논리합(두개의값이 다를 때만)
		z = x ^ y;
		System.out.println("x ^ y=" + z);
		// 1011 0010   => 뽑고자 하는 비트를 제외한 나머지를 모두 0으로 바꿈
		// 0001 0000 후 & 연산자를 사용하면 원하는 비트만 뽑을 수 있다
		
		// ~ : 1의 보수
		x=-1; // 1111 1111 1111 1111 
		z=~x; // 0000 0000 0000 0000
		System.out.println("~x= " + z);
		
		// -2의 비트 0000 0010 => 1111 1101 => 2의 보수 1111 1110
		
		int temp = 0xfffffffe;
		System.out.println(temp);
		
		// x<<1  0000 0001 => 0000 0010
		x=1;
		x=x<<1;
		System.out.println(x); 
		
		x=x<<1;
		System.out.println(x); 
		
		x=x<<1;
		System.out.println(x); 
		
		x=1;
		x=x<<31;
		System.out.println(x); // 가장 맨 앞으로가서 부호가 바뀌어 음수로 된다
		
		x=1;
		x=x<<30;
		System.out.println(x); 
		
		x=Integer.MIN_VALUE;
		System.out.println(x);
		
		x=x>>>1;
		System.out.println(x); // 음수가 양수로 바뀌는게 중요하다
		
		x=Integer.MIN_VALUE;
		x=x>>1; //부호자리에는 부호가 그냥 있는 상테
		//1000 0000 0000 0000 0000 0000 0000 => 1100 .... 음수인 상태는 유지한다 이처럼
		
		int A=0b10101000;
		int B=0b11101000,Z;
		Z= A & B;
		System.out.println(Z);
		
	}

}
