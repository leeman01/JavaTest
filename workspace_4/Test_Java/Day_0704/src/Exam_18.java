/*
 * [문제] n까지의 자연수 합
 * 
 * [문제] n까지의 팩토리얼을 구하시오
 */

import java.util.Scanner;

public class Exam_18 {

	public static void main(String[] args) {
	
		Scanner keyin = new Scanner(System.in);
		int i =1,sum=0,j;
		long m=1;
		System.out.println("자연수 n을 입력하시오");
		j = keyin.nextInt();
		while (true) {
			sum+=i;
			m=m*i;
			i+=1;
			
			if  (i>j) {
				System.out.println("자연수 1에서"+j+"의 총합은"+sum+"입니다");
				System.out.printf("자연수 j까지의 팩토리얼은 %,d 입니다",m);
				break;
			}
		
			
					
		}
			
	}
		
}
