/*
 * 1~10까지 홀수만 출력(while)
 */
public class WhileTest_01 {

	public static void main(String[] args) {
		int i =1 ;
		// while (true) 무한반복
		while (true) {
			System.out.println(i);
			i+=2;
			if (i>=10) break;
		}
		System.out.println("끝");
	}

}
