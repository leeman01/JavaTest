/*
 * 문제 설명[ 평균구하기]
정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.

제한사항
arr은 길이 1 이상, 100 이하인 배열입니다.
arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.
 */
package month7;

import java.util.ArrayList;
import java.util.Arrays;

public class Num_7 {

	public static void main(String[] args) {
		int [] arr2 = {1,2,3,4,5};
		System.out.println(solution(arr2));

	}
	private static double solution(int[] arr) {
		int sum = 0;
		for(int i=0;i<arr.length;++i) {
			sum+=arr[i];
		}
		return (double)sum/arr.length ;
		
	}
	// stream을 이용한 간략한 풀이 
	private static int answer(int[] arr) {
		return (int) Arrays.stream(arr).average().orElse(0);
	}
}
