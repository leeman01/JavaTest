/*
 * [문제] 마트에서 물건을 구매하였습니다 
 * 물건의 총금액을 입력받고 현금으로 지불합니다, 또 현금으로 지불할 금액또한 입력받습니다 거스름돈을 출력하시오
 * 만약 현금 지불액이 적을 경우에는 얼마가 부족한지 출력하시오
 * 
*/

import java.util.Scanner;

public class Exam08 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int value,value1,output;
		
		System.out.print("물건의 금액을 입력하시오: ");
		value = keyin.nextInt();
		
		System.out.print("지불할 금액을 입력하시오: ");
		value1 = keyin.nextInt();
		
		output = value1- value;
		
		if (output > 0) {
			System.out.printf("%,d원 거르름돈입니다",output);
		}else if (output<0) { output = output * -1;
			System.out.printf("부족한돈은 이정도이니 %,d원 내놔",output); 
		}else  {
		System.out.printf("정상결제됐습니다");
		// System.out.println((output*-1) + "부족한돈은 이정도입니다") 이런식으로 풀이 가능
	}
		
	
		keyin.close();
	}
}
