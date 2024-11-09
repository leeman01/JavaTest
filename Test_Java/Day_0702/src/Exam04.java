/*
 * [문제4] 키를 지정한 후 표준체중을 구하시오!
 * 남성표준체중 = 키(m) * 키 *22
 * 여성표준체중 = 카 * 키 * 21
 * 
 * [추가문제] 성별,키와 몸무게를 키보드로 입력받아 표준체중을 구한 후 BMI와 비만도를 구하시오
 * 비만도 = 표준체중 대비 백분율 => 실제체중 / 표준체중 * 100
 */

import java.util.Scanner;

public class Exam04 {
	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		double key ;
		double weg;
		String gender;
		double std,bmi;
		double fatRatio;
		System.out.print("키를 입력하시오(cm): ");
		key= keyin.nextDouble()* 0.01; // 키 cm를 m로 변환햇다
		System.out.print("몸무게를 입력하시오(kg): ");
		weg = keyin.nextDouble();
		
		System.out.print("성별을 입력하시오(남/여): ");
		gender = keyin.next();
		// 데이터 준비 끝남
		//남자인지 아닌지에따라 표준체중을 달리해야힘
		if (gender.equals("남")) { // 기본자료형만 ==으로 비교
			std =key*key*22;
		}else {
			std = key*key*21;
		}
		bmi = weg / (key*key);
		fatRatio = weg / std * 100;
		System.out.printf("적정체중은 %.2f이고 bmi는 %.2f%n",std,bmi);
		System.out.printf("비만도(%%)는 %.2f%% 입니다",fatRatio);
		// 비만도는 xx.xx%입니다
		
		keyin.close();
	}
}

