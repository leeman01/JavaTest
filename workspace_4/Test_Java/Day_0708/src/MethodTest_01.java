
public class MethodTest_01 {

	public static void main(String[] args) {
		int a= 20;
		int b=30;
		// TODO Auto-generated method stub
		 // 호출(static method 안에서는  non-static을 호출할수 없다 => 그래서 add 에  static 해줌
		int test = add(a,b); // 이떄의 a b는 전달인자 (arguments)라고 한다
		System.out.println(test);
		System.out.println(multiply(a,b));
		
		test = power(a,3); // a의 3제곱을 하는 메소드
		
	}
	// 메소드를 선언했다(정의) - 클래스 메소드
	public static int add(int a, int b) { // 이때의  a b를 매개변수 파라미터값이라고 부른다 
//		int a =10;
//		int b=20;
		int result=a+b;
		return result;
	}
	public static int multiply(int a, int b) { // 메소드는 중괄호 생략이 안된다
		return a*b;
	}
	public static int power(int a, int b) {
		int result =1;
		for (int i=0;i<b;++i) 
			
			result=result*a;
		return  result;
		
	}
	
}
