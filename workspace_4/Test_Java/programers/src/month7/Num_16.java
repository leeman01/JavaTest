/*
 * 문제 설명
array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수,
 solution을 작성해주세요.
divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

제한사항
arr은 자연수를 담은 배열입니다.
정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
divisor는 자연수입니다.
array는 길이 1 이상인 배열입니다.
 */

package month7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Num_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,36,1,3};
		int [] answer =solution(arr,1);
		System.out.println(Arrays.toString(answer));

	}
	private static int[] solution(int[]arr,int divisor) {
		List<Integer> answer = new ArrayList<Integer>();
		for(int i:arr)
			if (i%divisor==0) {
				answer.add(i);
			}
	answer.sort(null);
	if (answer.size()!=0) {
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
		
			 // 담긴 숫자
		int[] a = {-1};
		return a;
		
	}
	// 정답 코드
	// filter 와 map의 개념
	/*
	 * filter: 주어진 조건에 맞는 요소들만을 필터링합니다.
		map: 스트림의 각 요소를 주어진 함수에 따라 변환(mapping)합니다.
		List<Integer> result = Arrays.stream(arr)  // 스트림 생성
                             .filter(i -> i % 2 == 0) // 짝수만 필터링
                             .map(i -> i * 2) // 각 요소를 두 배로 변환
                             .collect(Collectors.toList()); // 리스트로 수집

	 */
	private static int[] answer(int[] arr,int divisor) {
		
		return Arrays.stream(arr).filter(factor->factor%divisor==0).toArray();
		
		
		
	}
}
