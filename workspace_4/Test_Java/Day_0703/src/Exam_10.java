/*
 * [문제] 세 자리의 정수를 입력하시오
 * 			System.exit(1); => 강제종료
 * 			각자리에 있는 DIGIT값을 합한 결과를 출력하시오
*/

import java.util.Scanner;

public class Exam_10 {

	public static void main(String[] args) {
		 
		Scanner keyin = new Scanner(System.in);
		int a ,b,c,d,e;
		//System.out.print("정수를 입력해: ");
		System.out.print(">> 정수를 입력하시오: ");
		a= keyin.nextInt();
		b=a/100;
		c= a%100/10;
		//System.out.println(c+a);
		d= a%10;
		//System.out.println(d);
		e= b+c+d;
		if (a>=100 && a<1000) {  // (a<100 || a > 999) 이 조건으로도 가능하다
			System.out.println(e);
		}else {
			System.out.println("3자리수만 가능함");
			System.exit(1); // 이건 강제종료
			//return; // 이건 원래상태로 되돌리기
		}
		
	}

}
