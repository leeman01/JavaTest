/*
 * [문제] 
 * 난수 1~100의 수 한개를 발생 시킨다
 * 5번안에 맞춰야 한다
 */

import java.util.Scanner;

public class Exam_27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = (int)(Math.random()*100+1) ;
		int b;
		Scanner scanner = new Scanner(System.in);
		System.out.println(a);
		for(int i=0; i<5;++i) {
			System.out.println("숫자입력");
			b = scanner.nextInt();
			if (a>b) {
				System.out.println("숫자를 더 크개");
			}else if (a<b) {
				System.out.println("숫자를 더 작개");
			}else if (a==b) {
				System.out.println("정답");
				break; //System.exit(0) 로도 종료가 가능하다
			
			}
			if (a!=b && i==4) System.out.println("처음부터하세요");		
		}

	}

}
