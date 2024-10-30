package array_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ArrayTest_113p {

	public static void main(String[] args) {
	
	int [] numbers = {2,1,3,4,1};
	int [] answer = solution(numbers);
	System.out.println(Arrays.toString(answer));
	System.out.println(answer.toString());
	}
	// 이건 정답과 동일햇다 다만 i랑 j를 동일한 값을 주어 같은 인덱스 값끼리 더하지 않도록 주의하자
	private static int[] solution(int[] list) {
		
		HashSet<Integer> set = new HashSet();
		
		for(int i=0 ; i<list.length;++i) {
			for(int j=i+1 ; j<list.length ; ++j) {
				set.add(list[i] + list[j]);
			}
		}
		// 이과정을 통해 2개씩 뽑아서 더한다는 과정을 마침 => 이후 정렬해야한다
		
		return set.stream().sorted().mapToInt(Integer::intValue).toArray();
		
	}
}
