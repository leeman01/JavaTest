import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Da70725_109p_Exam {
	public static void main(String[] args) {
		int [] List = {1,2,3,23,44,123,1,3,2};
		int [] List2 = {1,2,3,23,44,123,1,3,2};
		long start =System.currentTimeMillis();
		for (int z: solution(List))
			System.out.print(z+" ,"); 
		long end = System.currentTimeMillis();
		System.out.println();
		System.out.println("일반정렬: "+ (end-start)/1000.0 +" : 초");
		
		for (int z: List)
			System.out.print(z+" ,"); // 이 값은 정렬후 원본에 변화를 줌
		System.out.println();
		for (int z: solution2(List2))
			System.out.print(z+" ,");	
		System.out.println();	
		for (int z: List2)
			System.out.print(z+" ,"); // 원본 변화가 없음
		System.out.println();
		
		System.out.println(Arrays.toString(solution3(List2)));
		// 여기서부터 버블 정렬이 걸리는 시간 테스트 해본다
		int [] arr1 = new int[1000];
		long start1 =System.currentTimeMillis();
		int[] bubble_sort = solution3(arr1);
		long end1 = System.currentTimeMillis();
	
		// 버블 정렬시간이 얼마나 걸리는지 측정
		System.out.println("버블정렬: "+ (end1-start1)/1000.0 +" : 초");
	
	}
	
	private static int[] solution(int [] arr) {
		Arrays.sort(arr);
		return arr;
	}
	// w-정렬된 배열 토해내기 + 원본 배열에 영향 안주기
	private static int [] solution2 (int[] arr) {
		int [] clone = arr.clone();
		Arrays.sort(clone);
		return clone;
	}
	// 버블 정렬 구축하기-- 잊지않도록 주의해보자
	private static int[] solution3 (int[] arr) {
		for (int i=0 ;i<arr.length-1;++i ) {
			for (int j=0; j<arr.length-1;++j) {
				if (arr[j]<arr[j+1]) {
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		return arr;
	}

}


