package hashtest;

import java.util.HashSet;

public class HashTest_236p {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,8};
		System.out.println(solution(arr,6));

	}
	private static boolean solution(int [] arr,int target) {
		HashSet <Integer> set = new HashSet<>();
		for(int i:arr) {
			if(set.contains(target-i)) {
				return true;
			}
			set.add(i);
		}
		return false;
	
	}
}
