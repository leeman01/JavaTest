package month7;

import java.util.Arrays;

public class Num_30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] {1,2},new int[] {3,4}));

	}
	private static int solution(int[] A, int[] B) {
		// 각 과정이 끝날 때마다 sum할 값이 필요
		Arrays.sort(A);
		Arrays.sort(B);
		int length = A.length ;
		int answer = 0;
		
		for(int i=0 ; i<length ; ++i) {
			answer +=A[i] * B[length-1-i] ;
		}
		return answer ;
	}
	// 곱셉으로 가장 작은 합을 구하기 위해서는 작은값 * 큰값으로 더해야한다
	// 이로인해 A는 오름차순 정렬 B는 내림차순 정렬을 실행햇다
	
}
