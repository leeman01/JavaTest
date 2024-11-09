package november;

import java.util.HashSet;
import java.util.Set;

public class Day1109 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = {7,9,1,1,4};
		System.out.println(solution(list));

	}
	
	public static int solution(int[] elements) {
        int answer = 0;
        int cnt = 0;
        int sum=0;
        Set<Integer> set = new HashSet<>();
        int [] dp = new int[elements.length];
        for(int i=1;i<=elements.length;++i) {
        	// 길이가 1인 배열은 무조건 들어감
        	
        	for(int z=0;z<elements.length;++z) {
        		dp[i]+=elements[(i+z-1)%elements.length];
        	}
        	set.add(dp[i]);
        	System.out.println("cnt의 숫: " + cnt);
        	System.out.println(set.toString());
        }
        return set.size();
    }
}
