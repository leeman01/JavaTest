/*
 * 길이가 같은 두 1차원 정수 배열 a, b가 매개변수로 주어집니다. a와 b의 
 * 내적을 return 하도록 solution 함수를 완성해주세요.

이때, a와 b의 내적은 a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1] 입니다. (n은 a, b의 길이)
 */
package month7;

import java.util.stream.IntStream;

public class Num_21 {

	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		int[] b = {-3,-1,0,2};
		System.out.println(solution(a,b));

	}
	private static int solution(int [] a, int [] b) {
		int target =0;
		for(int i=0;i<a.length;++i) {
			target+=a[i]*b[i];
		}
		return target;
	}
	// 이건 뭘까...
	private static int so2ution(int[]a , int[] b) {
		return IntStream.range(0, a.length-1).map(index->a[index]*b[index]).sum();
	}

}
