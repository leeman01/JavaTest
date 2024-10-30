/*
 * 두 정수 left와 right가 매개변수로 주어집니다. left부터 right까지의 모든 수들 중에서, 
 * 약수의 개수가 짝수인 수는 더하고, 
 * 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
 */

package month7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Num_22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(24,27));

	}
	private static int solution(int left,int right) {
		
		int sum=0;
		// 약수의 개수를 구하기 전 사이의 값들을 리스트로 만들자
		int[] target =IntStream.range(left, right+1).toArray();
		List<Integer> cnt = new ArrayList<>();
		for(int i=0; i<target.length;++i) {
			int num=0;
			for(int z=1 ; z<= target[i] ; ++z) {
				if(target[i]%z==0)
					num+=1;
			}
			cnt.add(num);
		}
//		return cnt.stream().mapToInt(Integer::intValue).toArray();
		for(int k=0; k<cnt.size();++k) {
			if(cnt.get(k)%2==0) {
				sum+=target[k];
			}else {
				sum-=target[k];
			}
		}
		return sum ;
		
	}
	// 다시 느껴진 벽
	private static int s2lution(int left,int right) {
		int answer=0;
		for(int i=left ; i<=right ; ++i) {
			if(i%Math.sqrt(i)==0) {
				answer-=i ; // 제곱수인 
			}else {
				answer+=i;
			}

		}
		return answer;
	}

}
