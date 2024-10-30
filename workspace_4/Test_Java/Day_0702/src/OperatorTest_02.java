/*
 * 양수인지 음수인지  들여쓰기 : cntrl + i
 * 그리고(값의 범위를 확인할 때)
 * true && true => true 둘다 true에만 true값이다
 */

import java.util.Scanner;
q
public class OperatorTest_02 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int value;
		
		System.out.print("정수를 입력: ");
		value = keyin.nextInt();
		
		if (value  ==0) {
			System.out.println("이 값은 0 입니다");
		} else if (value < 0){
			System.out.println("이 값은 음수입니다");
		} else if (value>0) {
			System.out.println("이 값은 양수입니다");
		}
	
		keyin.close();

	}
}
