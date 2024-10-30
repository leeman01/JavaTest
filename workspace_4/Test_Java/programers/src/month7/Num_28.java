/*
 * 이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.
 */
package month7;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Num_28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner system= new Scanner(System.in);
		System.out.println("가로길이를 입력: ");
		int a = system.nextInt();
		System.out.println("세로길이를 입력: ");
		int b = system.nextInt();
		String A ="";
		for(int i=0;i<b;++i) {
			for(int z=0;z<a;++z) {
				A+="*";
				if(z==a-1)
					A+='\n';
			
			}
		}
		System.out.println(A);
		
		
		StringBuilder sb = new StringBuilder();
		IntStream.range(0, a).forEach(s->sb.append("*"));
		IntStream.range(0, b).forEach(s-> System.out.println(sb.toString()));
	}
		

}
