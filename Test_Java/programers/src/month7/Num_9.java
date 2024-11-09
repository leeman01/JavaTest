/*
 * 문제 설명 [두 정수사이의 합]
두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.

제한 조건
a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
a와 b의 대소관계는 정해져있지 않습니다.
 */
package month7;

public class Num_9 {

	public static void main(String[] args) {
		System.out.println(solution(3,9));

	}
	public static long solution(int a, int b) {
		int x = Math.min(a, b);
		int y = Math.max(a, b) ;
		int sum=0;
		for(int i=x ; i<=y;++i)
			sum+=i;
		return (long)sum;
	}
	// 등차수열의 공식으로 풀기
	private static long answer1(int x ,int y) {
		return sumAtoB(Math.min(x, y),Math.max(x, y));
	}
	private static long sumAtoB(long a ,long b) {
		return (b-a+1)*(a+b)/2;
	}
	//  삼항연산자의 사용
	private static long answer2(int a,int b) {
		long answer=0;
		for(int i=(a>b ? a: b) ; i<=(a<b ? b :a);++i)
			answer+=i;
		return answer ;
	}
}
