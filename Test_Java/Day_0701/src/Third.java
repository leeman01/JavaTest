// 주석 (한줄주석)
/*
 * *이안에 있는 것들은 모두 주석
 * 여러줄주석. 이 사이에 있는 것만 주석처리된다
 */ 
/**
 * 클래스 위에 썻으니까 클래스의 설명을 기재 => 나중에 문서로 생성할수잇음
 */
public class Third {
	/**
	 * 문서주석, 메소드의 설명을 기재 => 문서로 생성해줌
  	 * @param c
	 */
	public static void main(String[] c) {// 이 뒤는 모두 주석
		// 정수 타입의 사용
		byte a = 10; // 변수를 선언하고 값을 초기화 (initialize)
		a = -128; // 이는 초기화가 아닌 대입이라한다(assignment)
		short b = 123; // 무조건 선언해야한다
		int i = 10;
		// i=52L; 큰 메모리의 값을 작은 메모리에 넣을려고해서 생기는 오류
		long lo =10L;
		System.out.println(a);
		System.out.println(b);
		System.out.println(i);
		System.out.println(lo);
		System.out.println("========");
		
		
		float f = 42.195F;
		double d = 3.141595 ;
		double d1=3.14E12;
		System.out.println(f);
		System.out.println(d);
		System.out.println(d1);
		System.out.println("========");
		
		char ch = 'a';
		char ch1 =97;
		char ch2 = '가';
		System.out.println(ch);
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println((int)ch2);
		System.out.println('a'>'b');
		System.out.println((int)' ');
		System.out.println((char)('a'-' '));
	}
}
/* 
 * 자바의 자료형(Data type) 1byte == 8bit
 * 1) 기초 자료형 (primitive type) : stack 메모리 공간에 데이터 저장
 * 	수치형  -byte(1) -128 ~ 127까지 넣을 수 있다
 * 			-short(2): 16비트 할당
 * 			-int(4): -2147483648 ~ 2147483647 32비트 할당
 * 		    -long(8): 64비트 할당
 * 			- float(4) : 
 * 			- double(8):
 * 			- char(2): 음수 값을 넣을 수 없다, 문자를 저장하기 위한 용도
 * 진위형 - boolean(1): true ,false 값을 처리
 * 
 * 2)참조형(refernce type): Heap 메모리공간에 데이터를 저장하고 , 그 저장위치를 변수에 담아서 사용
 * 			- class,array,enum....
 * 
*/	
