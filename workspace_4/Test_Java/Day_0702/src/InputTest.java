/*
 * 키보드로 데이터를 입력받기
 * 1) Scanner 객체선언
 * 2) 저장할 변수 
 * 3) 입력메소드를 이용해 입력
 * 4) 처리...
 */

import java.util.Scanner;

public class InputTest {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in); // Scanner는 개본객체가 아니라 Import 해야한다 cntrl+shift +o 자동 import
		int age ;
		double score;
		String name,gender;
		int a  = 10;
		// next()메소드는 Blocking 메소드이다, 무언가를 입력하고 엔터키를 쳐야 데이터가 입력된다
		System.out.print("나이입력: ");
		age = keyin.nextInt();
		
		System.out.print("점수를 입력: ");
		score=keyin.nextDouble();
		
		System.out.print("이름 입력: ");
		name = keyin.next();  // 키보드로 입력받을때 무조건 띄워쓰기 쓰면안된다  => 하나의 단어만 입력
		
		System.out.print("성별입력: ");
		gender=keyin.next();
		
		System.out.println("입력한 데이터는"+age+","+score+","+name+","+gender);

	}

}
