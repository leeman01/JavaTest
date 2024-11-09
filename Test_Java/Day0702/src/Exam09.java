/*
 * [문제] 마트에서 물건을 구매하였습니다 
 * 물건의 총금액을 입력받고 현금으로 지불합니다, 또 현금으로 지불할 금액또한 입력받습니다 거스름돈을 출력하시오
 * 만약 현금 지불액이 적을 경우에는 얼마가 부족한지 출력하시오
 * 
*/

import java.util.Scanner;

public class Exam09 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		double days=365.2422;
		double out,out1,out2,out3;
		int day,val1,val2;
		day = (int)days;
		//System.out.println(day);
		out = days - day;
		// 일은 24시간 => *24를 해서 --시간으로 만들어보자
		out1 = out*24;
		System.out.println(out1);
		val1 = (int)out1;
		// 여기서 시간은 나왓다
		out2 = out1-val1;
		System.out.println(out2); // 분을 만들어야 하니 곱하기 60
		out2 = out2 * 60;	
		val2 = (int) out2 ; // 분 값이 나왓다
		
		out3 = out2 - val2;
		//System.out.println(out3); //여기서는 초이다
		out3 = out3 *60; // 이값을 쓰자
		System.out.println("===================");
		System.out.print("1년은 365.2422일이고");
		System.out.print(day+"일"+val1+"시간"+val2+"분");
		System.out.printf("%.2f 초입니다",out3);
		int x=0;
		
		
		
	
	}
	
}
