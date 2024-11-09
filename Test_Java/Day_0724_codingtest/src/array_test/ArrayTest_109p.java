package array_test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class ArrayTest_109p {

	public static void main(String[] args) {
		int [] array = {1,52,52,2,3,4,5,1,1,1,1};
	
		for (int i : solution(array))
			System.out.print(i) ;
	}
	// 풀면서 어려웠던 점 : intValue 스펠링 헷갈림, stream 사용법 미숙
	private static int[] solution(int[] arr) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i=0 ; i<arr.length;++i) {
			set.add(arr[i]);
		}
		// 이렇게하면 중복된 값은 제거됨 이후 셋타입을 배열 array형태로 만들어야함
		
		return set.stream().sorted(Comparator.reverseOrder()).mapToInt(Integer :: intValue).toArray();
		
	}
	// box의 개념에 대해 짚고 넘어가자 : 이 기능은 객체가 아닌 요소를 객체로 형변환 할때 사용
	private static int [] solution2(int [] array) {
		
		Integer [] result = Arrays.stream(array).boxed().distinct().toArray(Integer[]::new);
		Arrays.sort(result,Comparator.reverseOrder());
		
		return Arrays.stream(result).mapToInt(Integer::intValue).toArray() ;
	}
}
