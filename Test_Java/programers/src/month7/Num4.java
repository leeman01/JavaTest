/*
 * 문제 설명
자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

제한 조건
n은 10,000,000,000이하인 자연수입니다.
입출력 예
 */
package month7;

import java.util.ArrayList;
import java.util.Arrays;

public class Num4 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(12345)));

	}
	private static int[] solution(int n) {
		ArrayList <Integer> array = new ArrayList<>();
		int answer=0;
		int i=0;
		while(true) {
			answer= n%10;
			if (n<1)
				break;
			n/=10;
			array.add(answer);
		}
		
		
		return array.stream().mapToInt(Integer::intValue).toArray() ;
	}

}
