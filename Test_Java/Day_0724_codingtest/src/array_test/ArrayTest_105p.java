package array_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ArrayTest_105p {

	public static void main(String[] args) {
		int [] a = {1,-5,2,4,3} ;
		List b = solution(a) ;
		System.out.println(b);
		int [] arr = solution2(a);
		for (int i : arr)
			System.out.print(i);
		
	}
	// 이런식으로 하면 코드만 길어지니까 Array  List set Map 의 차이점을 고려하면서 차분하게 풀자
	private static List solution(int [] array) {
		
		List list = new ArrayList();
		for(int i =0 ; i < array.length ; ++i) {
			list.add(array[i]);
		}
		Collections.sort(list);

		return list;
	}
	// 이게 진짜 정답
	private static int[] solution2(int [] array) {
		Arrays.sort(array);
		return array;
		
	}

}
