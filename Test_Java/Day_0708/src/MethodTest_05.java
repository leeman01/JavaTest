import java.util.Scanner;

public class MethodTest_05 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int x,y;
		double result=0;
		String choice=null;
		
		while(true) {
			System.out.print("1.더하기 2. 빼기 3. 곱하기 4. 나누기 0. 종류");
			choice = keyin.next();
			if(choice.equals("0")) break;
			System.out.println("숫자1를 입력: "); x=keyin.nextInt();
			System.out.println("숫자2를 입력: "); y=keyin.nextInt();
			switch(choice) {
			case "1" -> result = add(x,y);
			case "2" -> result = substact(x,y);
			case "3" -> result = multiply(x,y);
			case "4" -> result = divide(x,y);
			default -> System.out.println("잘못된 입력입니다");
			}
			System.out.println("결과는"+result);
		}
	}
	
	public static int add(int a, int b) {
		return a+b;
	}
	
	public static  int substact(int a, int b) {
		return a-b;
	}
	
	public static  int multiply(int a, int b) {
		return a*b;
	}
	
	public static double divide(int a, int b) {
		return (double)a/b;
	}

}
