/*
 * [문제] 정수를 입력받는다 그 값이 홀수인지 짝수인지 판단 단 비트 연산자(&)를 사용
 */ 

import java.util.Scanner;

public class Exam_13 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int a,z,x,q;
		int b;
		System.out.print("정수를 입력하시오: ");
		a= keyin.nextInt();
		System.out.print("정수를 입력하시오: ");
		x= keyin.nextInt();
		b=1;
		z= a & b;
		
		q= 0x80000000;  // 부호
		System.out.println(((x&q) ==0) ? "양수" : "음수");
		
		System.out.println(z);
		// result = (a&b ==0) ? "짝수" : "홀수";
		if (z == 1) {
			System.out.println("홀수입니다");
		
		}else {
			System.out.println("짝수입니다");
		}
		
		System.out.println(((a&b) ==0) ? "짝수" : "홀수");
		
		
	}

}
