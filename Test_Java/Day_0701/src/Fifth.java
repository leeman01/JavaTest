/*
 * [문제] 반지름이 5인 원의 면적을 구하는 프로그램 
 */
public class Fifth {
	public static void main(String[]args) {
		int radius =  5;
		final double PI = 3.14159; // 변수중에 값이 변화하면 안되는 것 = 대문자 / final 붙이기
		double area = PI * radius * radius; 
		System.out.println("반지름5인 원의 면적은"+area); // 소수점을 최대 6자리까지 출력
		System.out.printf("반지름 5인 면적%.2f",area); // 소수자리 2자리로 만들기
		
	}  

}
// 단축키
//cntrl + s :저장
//cntrl+ f11: 실행
//cntrl+D:한줄삭제
//cntrl+space :자동완성