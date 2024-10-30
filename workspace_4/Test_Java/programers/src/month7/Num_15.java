/*
 * 문제 설명[없는 숫자더하기]
0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다. 
numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 
더한 수를 return 하도록 solution 함수를 완성해주세요.
 */
package month7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num_15 {

	public static void main(String[] args) {
		int[] numbers = {5,8,4,0,6,7,9};
		// TODO Auto-generated method stub
		System.out.println(solution(numbers));
		

		
		
	}
	private static int solution(int[] numbers) {
		int a=0;
		int [] array = {0,1,2,3,4,5,6,7,8,9};
		for(int i=0;i<numbers.length ;++i) {
			a+=numbers[i];
		}
		int b=0;
		for(int z=0;z<array.length;++z) {
			b+=array[z];
		}
		return b-a ;
		
	}
}
