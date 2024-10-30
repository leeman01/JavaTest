/*
 * [문제] 정수로 입력받아 짝수인지 홀수인지 출력하시오
import java.util.Scanner;
*/

import java.util.Scanner;

public class Exam06 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int value;
		
		System.out.print("정수를 입력: ");
		value = keyin.nextInt();
		
		if (value % 2 ==0) {
			System.out.println("이 값은 짝수입니다");
		}else {System.out.println("이 값은 홀수입니다");
		}
	
		keyin.close();
	}
}
