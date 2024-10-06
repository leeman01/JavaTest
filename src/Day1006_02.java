import java.util.ArrayList;
import java.util.List;

public class Day1006_02 {

	public static void main(String[] args) {
	
		}

	
	public static Long[] solution(int x,int n) {
		List<Long> ans = new ArrayList<>();
		int a=0;
		for(int i=0;i<n;++i) {
			a+=x;
			ans.add((long)a);
		}
		return ans.toArray(new Long[0]);
	}
	
	// others solution
	public static long[] solutio1n(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;

        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + x;
        }

        return answer;

    }

}
