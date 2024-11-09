/*
 * [문제]  두과목의 점수(trade,it)와 출결점수를 각각 입력받는다 / 출결점수는 80점 이상, 나머지 과목의 평균은 60점 이상,과락없어야 수료한다고 한다
 * 수료여부를 출력하시오 => 삼항연산자만 사용
 */

import java.util.Scanner;

public class Exam_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyin = new Scanner(System.in);
		int trade,it,trade1,it2;
		double c;
		String result;
		System.out.print("무역의 점수를 입력하시오: ");
		trade = keyin.nextInt();
		
		System.out.print("IT의 점수를 입력하시오: ");
		it = keyin.nextInt();
		
		System.out.print("무역의 출결점수를 입력하시오: ");
		trade1 = keyin.nextInt();
		
		System.out.print("IT의 출결점수를 입력하시오: ");
		it2 = keyin.nextInt();
		
		c= (trade+it)/2;
		
		result = (trade1>=80 && it2>=80 && c>=60 && trade>=40 && it>=40) ? "통과" : "탈락";
		System.out.println(result);
	
	}

}
