
public class PrintTest {
	public static void main(String[] args) {
	// System.out.ptint()  : 데이터 단순출력=데이터가 무조건 필요하다
	// System.out.println([]): 데이터 출력, 줄바꿈, [] = 데이터가 없어도 된다는 의미 
	// System.out.printf([,데이터]): 무조건 첫번째로 문자열이와야함,데이터를 전달해 출력에 맞게 전달
	System.out.print("KITA DIMA 4기");
	System.out.println(); // 줄바꿈 
	System.out.println("너의 이름은" + "홍길동,나이는" + 25);
	
	// printf는 형식변환문자열이 필요
	// %f - 실수를 출력할때 사용 ,%d - 정수 , %s -문자열 설명 ,%c -문자한개, %n - 줄바꿈, %% - % 자체 표현
	String name = "손오공";
	// name의 타입은  string으로 문자열이다
	System.out.printf("너의 이름은 %s!!!!!!!!!%n",name); // printf는 줄바꾸기는 못함
	// %N으로 줄바꿈
	System.out.printf("너의 이름은 %10s!!!!!!!!!%n",name); // 빈공간(space) 10개
	System.out.printf("너의 이름은 %-10s!!!!!!!!!%n%n",name);
	
	int value = 1234567890 ;
	System.out.printf("나의 재산 %,d원이다%n",value); // % d 사이에 ,을 쓰면 다음과 같이...
	
	double pi = 3.141592;
	System.out.printf("원주율은 %.2f%n%n",pi);
	
	char ch = '♥';
	System.out.printf("나의 마음은 %c 입니다.%n",ch);
	
	double ratio = 0.95;
	System.out.printf("%.2f%%%n",ratio); // %%  이면 0.95% 이런식으로 표현이 가능하다
	
	
	
	
	
	
	}

}
