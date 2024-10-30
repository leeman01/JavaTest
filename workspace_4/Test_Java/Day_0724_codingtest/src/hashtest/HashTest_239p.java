package hashtest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class HashTest_239p {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] arr1 = {"leo","kiki","eden"};
		String [] arr2 = {"eden","kiki"};
		System.out.println(solution(arr1,arr2));
		System.out.println(solution2(arr1,arr2));
	}
	private static String solution(String [] arr1,String [] arr2) {
		HashSet<String> set1 = new HashSet<>(Arrays.asList(arr1));
		HashSet<String> set2= new HashSet<>(Arrays.asList(arr2));
		
		set1.removeAll(set2);
		return set1.toString();
		
	}
	private static String solution2(String [] s ,String[] s1) {
		HashMap<String,Integer> map = new HashMap<>();
		for(String string : s1)
			map.put(string, map.getOrDefault(string, 0)+1); // 기존에 없는 값이면 1을 더하기
		for(String string: s) {
			if(map.getOrDefault(string, 0)==0) {
				return string;
			}
			map.put(string,map.get(string)-1);
		}
		return null;
	}
}