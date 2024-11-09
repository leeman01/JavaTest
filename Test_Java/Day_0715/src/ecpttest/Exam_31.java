/*
 * [문제] 정수 5개를 반복적으로 입력받아 총합계를 구하는 프로그램을 작성하시오
 */
package ecpttest;

import java.util.Scanner;

public class Exam_31 {

	public static void main(String[] args) {
		Scanner keyin = 	new Scanner(System.in);
		int count =0;
		int sum = 0 ;
		
		while (true) {
			
			try {
				int count1 =count+1;
				System.out.println("값" + count1 + "=> ");
				int target = keyin.nextInt(); // 오류 날 롹률이 있는 코드 // 잘못 입력된 데이터를 지우는 작업을 거쳐야한다
				sum+=target;
				System.out.println("총합: " + sum);
			}catch (Exception e) {
				keyin.nextLine(); // 버퍼안의 모든 데이터를 가져옴
				continue;
			
			}
			count++;
			if (count==5) {
				System.out.println("총합: " + sum);
				break;
			}
		}
	
		
		
	}

	

}
