/*
 * [문제] 정수를 입력받는다 그 정수의 모든 비트를 출력하시오  단 비트 연산자 (&,>>>)를 사용할것
 */ 

import java.util.Scanner;

public class Exam_14 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int x,y;
		x=0x80000000 ;
		
		
		System.out.print("정수를 입력하시오: ");
		y= keyin.nextInt();
		
		for(int i=1; i <= 32 ; ++i) {
			System.out.print( (x&y)==0 ? "0" : "1" );
			x=x>>>1;
			if (i%4==0 ) {
				System.out.print(" ");
			}
		}
		
		
		
		
	}

}

