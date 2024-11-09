package array_test;

import java.util.ArrayList;
import java.util.HashMap;

public class Game_Test_123P {

	public static void main(String[] args) {
		int [] stage = {4,4,4,4,4};
		int[] array = solution(4,stage) ;
		for(int i : array)
			System.out.print(i+",");
	}
	private static int[] solution(int N,int[] array) {
		int [] result = new int [N+2];
		int cnt=1;
		int total = array.length ;
 		// List로 단계를 통과한 사람이 몇명인지 파악해보자
		for (int i=0 ; i<array.length ;++i) {
			result[array[i]] +=1;
			
		}
		HashMap<Integer,Double> fails = new HashMap<>();
		for(int i=1 ; i<=N ; ++i) {
			if (result[i]==0) {
				fails.put(i, (double) 0);
			}else {
				fails.put(i, (double) (result[i]/total)) ;
				total-=result[i] ;
			}
		}
		return fails.entrySet().stream().sorted((o1,o2)->Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry :: getKey).toArray() ;
	}

			
}
