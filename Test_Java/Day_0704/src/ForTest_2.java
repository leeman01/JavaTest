/* 
 * 구구단 출력하기
 */

import java.util.Scanner;

public class ForTest_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int dan;
		
		System.out.println("몇단을 출력할까요?");
		dan = scanner.nextInt();
		
		for (int i=1 ; i<=9; ++i) 
			System.out.println(dan +"*"+i+"="+(dan*i));

	}

}
