/*
 * [문제] 1~127 까지의 코드값과 그에 해당하는 실제 문자를 출력하십시오
 * 
 * [문제] n까지의 팩토리얼을 구하시오
 */

import java.util.Scanner;

public class Exam_19 {

	public static void main(String[] args) {
		int i=1;
		char b ;
		while(i<128) {
			b= (char)i;
			System.out.println(i +":"+ b);
			i+=1;
		}
		System.out.printf("===========%d%n",(int)('\n'));  // new line
		System.out.printf("===========%d%n",(int)('\r'));  // carriage return
		System.out.println("1\t2\t3");
	}
		
}
		
