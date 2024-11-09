/*
 * [문제] 키를 지정한 후 표준체중을 구하시오!
 * 남성표준체중 = 키(m) * 키 *22
 * 여성표준체중 = 카 * 키 * 21
 * 
 * [추가문제] 성별,키와 몸무게를 키보드로 입력받아 표준체중을 구한 후 BMI를 계산하시오
 */

import java.util.Scanner;

public class Exam_16 {
	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		double key ;
		double weg;
		String gender,out="";
		double std,bmi;
		System.out.print("키를 입력하시오(cm): ");
		key= keyin.nextDouble()* 0.01; // 키 cm를 m로 변환햇다
		System.out.print("몸무게를 입력하시오(kg): ");
		weg = keyin.nextDouble();
		
		System.out.print("성별을 입력하시오(남/여): ");
		gender = keyin.next();
		// 데이터 준비 끝남
		//남자인지 아닌지에따라 표준체중을 달리해야힘
		
		// 여기부터 switch문으로 수정
		bmi = switch(gender) {
		case "남" -> (weg/(key*key));
		case "여" -> (weg/(key*key));
		default -> 0 ;
		};
		std = switch(gender) {
		case "남" -> (key*key*22);
		case "여" -> (key*key*21);
		default -> 0 ;
		
		};
		
		if (bmi>=35) {
			out = "고도비만";
		}else if(bmi >=30 && bmi<=34.9) {
			out = "중도비만";
		}else if(bmi>=25 && bmi<=29.9) {
			out = "경도비만";
		}else if(bmi>=23 && bmi<=24.9) {
			out = "과체중";
		}else if (bmi>=18.5 && bmi <=22.9) {
			out = "정상";
		}else if(bmi>0 && bmi <18.5) {
			out = "저체중";
		}else if (bmi ==0) {
			out="성별을 제대로 입력해주세요";
		}
		System.out.println(out);
		System.out.println(std);
		keyin.close();
	}
}

