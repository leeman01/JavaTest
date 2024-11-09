/*
 * public static void exchange(int a, int b)
 * call by value : 값에 의한 호출, 원본에 접근할수 없다
 * call by reference :참조에 의한호출, 원본에 접근이 가능
 */
public class MethodTest_03 {

	public static void main(String[] args) {
		int a=10;
		int b=20;
		System.out.println("a="+a+","+"b="+b);
		exchange(a,b);
		System.out.println("a="+a+","+"b="+b);
	}
	
	public static void exchange(int a, int b) {
		int tempt;
		tempt =a;
		a=b;
		b=tempt;
	}
}
