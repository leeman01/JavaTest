/*
 * [문제] 놀이동산에서 논다고 할때 키가 150 ~180까지만 탈수있고 너무 작거나 큰 사람은 놀이기구 못탐
*/

import java.util.Scanner;

public class Exam07 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int value;
		
		System.out.print("키를 입력하시오: ");
		value = keyin.nextInt();
		
		if (value >= 150 && value <=180) {
			System.out.println("즐거운 시간 보내세요");
		}else {System.out.println("저리 가세요");
		}
	
		keyin.close();
	}
}
