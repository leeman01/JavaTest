package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Collection_study_388p {

	public static void main(String[] args) {
		int[] array = new int [5];
		Arrays.setAll(array, i -> (int)(Math.random()*5+1));
		for (int z : array)
			System.out.println(z);
		   
		// 배열의 정렬과 검색
		int [] arr1 = {3,2,1,3,5,6};
		int idx = Arrays.binarySearch(arr1, 2);
		System.out.println(idx); // binarysearch의 경우 배열이 정렬되어 있어야지 올바른 값을 도출한다
		// 만약 값이 여러개 있다면 그 중에 어느것이 반환될지는 모른다
		Arrays.sort(arr1);
		System.out.println(Arrays.toString(arr1));
		int idx2 = Arrays.binarySearch(arr1, 2);
		System.out.println(idx2);
		// to string은 익숙하지만 방심하지 말자 => 1차 배열은 가능하지만 2차 이상부터는 depptostring을 사용해야한다
		int[][] list = {{1,2,3,4,5},{6,6,6,6,6}};
		System.out.println(Arrays.deepToString(list));
		// equals 같은 경우도 1차배열에서만 사용가능 => 2차 이상의 배열부터는 deep을 사용해한다
		int [] [] list2 = {{1,2,3,4,5},{1,2,3,4,5}};
		System.out.println(Arrays.deepEquals(list, list2));
		
		// 배열을 리스트로 변환
		List list3 = Arrays.asList(new Integer[] {1,2,3,4,5});
		List list4 =Arrays.asList(1,2,3,4,5);
		
//		list4.add(6); 이경우는 오류 발생함 =>  aslist가 반환한 리스트의 크기는 변경이 불가능하다
		List array2 = new ArrayList(Arrays.asList(1,2,3,45,4)); // 이와 같은 방식으로 만들면 리스트의 크기 변경이 가능해진다
		
		List a = new ArrayList(Arrays.asList(1,2,3,4,5));
		Integer c =5;
		a.add(c);
	   
	
		for (int i=0;i<a.size();++i)
			System.out.println(a.get(i));
		// set은 중복을 허용하지 않는다 만약 중복된 값을 넣으면 어떻게 되는지?
		HashSet<Integer> a2= new HashSet<>();
		a2.add(1);
		a2.add(1);
		System.out.println("결과값");
		a2.forEach(i -> System.out.print(i));
	}
	public static int [] solution(int [] a) {
		HashSet<Integer> target = new HashSet<>();
		for (int i=0;i<a.length-1;++i) {
			for(int j=i+1;j<a.length;++j) {
				target.add(a[i]);
				target.add(a[i]+a[j]);
			}
		}
		
		return target.stream().mapToInt(Integer::intValue).toArray();
		
	}

}
