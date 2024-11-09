/* 
 * 원의 반지름을 입력하여 원의 면적을 구하는 프로그램을 작성하시오
 */
import java.util.Scanner;
public class StaticTest {

	public static void main(String[] args) { //static에서 non static으로 접근이 안됨
		
		double a;
		Scanner keyin =new Scanner(System.in);
		// public static final double PI
		System.out.println("반지름을 입력: ");
		a =keyin.nextInt();
		System.out.println(a*a*Math.PI);
		// public static print Stream out;
	}

}
