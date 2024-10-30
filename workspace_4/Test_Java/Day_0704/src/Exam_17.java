/*
 * [문제] 어떤 놀이동산에서 열차에 사람을 태워서 출발하려고한다
 * 무조건 5명이 채워져야 출발가능
 * 그런데 그 열차에 탈수있는 사람은 키가 150에서 180 사이어야 한다
 * 
 * 키: 151
 * 1명 탑승
 * 키: 189
 * 1명탑승
 */

import java.util.Scanner;

public class Exam_17 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		double key;
		
		int i=0;
		while(true) {
			
			System.out.println("키가 얼마?: ");
			key= keyin.nextDouble();
			
			if (key>=150 && key<=180) i+=1;
			System.out.println("총"+i+"명 탑승햇습니다");
			
			if (i==5) {
				System.out.println("열차가 출발합니당");
				break;
			}
			
		
		}
		

	}

}
