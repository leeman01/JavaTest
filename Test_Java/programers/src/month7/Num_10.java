/*
 * 문제 설명[약수의합]
정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.

제한 사항
n은 0 이상 3000이하인 정수입니다.
 */

package month7;

import java.util.HashSet;
import java.util.Set;

public class Num_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(5000));
		// 중복된값이 있으면 안되니 set을 사용해야 한다

	}
	private static int solution(int n) {
		Set <Integer> set = new HashSet<>();
		for(int i=1;i<10;++i) {
			if(n%i==0) {
				set.add(i); 
				set.add(n/i);
			}
			
		}
		return set.stream().mapToInt(Integer::intValue).sum();
			
	}
	private static int answer(int num) {
		int answer=0;
		for(int i=1;i<=num;++i) {
			if (num% i==0) {
				answer+=i;
			}
		}
		return answer;
	}

}
