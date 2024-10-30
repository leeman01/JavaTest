/*
 * 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.

제한사항
N의 범위 : 100,000,000 이하의 자연수
 */

package month7;

public class Num3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static int solution(int n) {
		int answer=0;
		while(true) {
			answer += n%10;
			if (n<10)
				break;
			n/=10;
		}
		return answer;
	}
}
