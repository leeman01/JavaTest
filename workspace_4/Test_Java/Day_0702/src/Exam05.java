/*
 * [문제] 이름, 국어,영어,수학 점수를 정수로 입력받아
 * 합계와 평균을 구하여 출력하시오, 이때 평균은 소수점 이하 2자리 까지 나온다
 */

import java.util.Scanner;

public class Exam05 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		
		String name;
		int a; // 순서대로 국어 영어 수학
		int b;
		int c,sum;
		double avg;
		
		System.out.print("이름을 입력하시오: ");
		name = keyin.next();
		
		System.out.print("국어점수 입력: ");
		a= keyin.nextInt();
		
		System.out.print("영어점수 입력: ");
		b= keyin.nextInt();
		
		System.out.print("수학점수 입력: ");
		c= keyin.nextInt();
		
		sum = a+b+c;
		//avg = sum / 3.0 ;
		avg = (double)sum/3;  // 캐스팅 과정이라한다
		System.out.print(name+"의 점수의합은 ");
		System.out.printf("%d이고 평균은 %.2f 이다",sum,avg);
		
		keyin.close();
		

	}

}
