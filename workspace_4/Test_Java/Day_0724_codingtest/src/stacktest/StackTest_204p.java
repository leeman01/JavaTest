package stacktest;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Queue;

public class StackTest_204p {

	public static void main(String[] args) {
		int [] art= {95,90,99,99,80,99};
		int [] art1= {1,1,1,1,1,1};
		int [] art3= {1,1,1,1,1,1};
		int [] art4= {1,1,1,1,1,1};
		int [] ary = solution(art,art1);
		System.out.println(Arrays.toString(ary));

	}
	private static int[] solution(int [] ary,int [] ary1) {
		HashMap<Integer,Integer> map = new HashMap<>();
		Queue<Integer> answer = new ArrayDeque<>();
		int []Daysleft = new int[ary.length] ;
		for(int i=0;i<ary.length;++i) {
			Daysleft[i] = (int)Math.ceil(100.0-ary[i]/ary1[i]);
		}
		int cnt=0;
		int maxday = Daysleft[0] ;
		for(int i=0;i<ary.length;++i) {
			if (Daysleft[i]<=maxday) {
				cnt++;
			}else {
				answer.add(cnt);
				cnt=1;
				maxday = Daysleft[i];
			}
			
		}
		answer.add(cnt);
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

}
