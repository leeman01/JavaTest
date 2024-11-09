/*
 * [문제] 숫자를 입력받음
 * 숫자 1:50
 * 숫자 2:40
 * 어떤연산? 
 * 1) 덧셈 2) 뺄셈 3) 곱셈 4) 나눗셈 ==> 
 */

import java.util.Scanner;

public class Exam_15 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		double x,y;
		 int val;
		double result;
		System.out.print("숫자1을 입력하시오: ");
		x= keyin.nextDouble();
		
		System.out.print("숫자2을 입력하시오: ");
		y= keyin.nextDouble();
		
		
		System.out.println("어떤연산? ");
		System.out.print("1) 더하기 2) 빼기 3) 곱하기 4) 나누기: ");
		val= keyin.nextInt();
//		switch (val) {
//		case 1: result = x+y; break;
//		case 2: result = x-y; break;
//		case 3: result = x*y; break;
//		case 4: result = x/y; break;
//		default: System.out.println("1,2,3,4 중에서 선택하시오");
//		}
//		System.out.println(result);
		
		
		result= switch(val) {
		case 1 -> x+y;
		case 2 -> x-y;
		case 3 -> x*y;
		case 4 -> x/y;
		default-> 0 ;
		};
	}

}
