/*
 * 정수제곱근 판별
 * 문제 설명
임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.

제한 사항
n은 1이상, 50000000000000 이하인 양의 정수입니다.
입출력 예
 * 
 * 문제없이 넘어감
 */
package month7;

public class Num_6 {

	public static void main(String[] args) {
		System.out.println(Math.sqrt(5));
		System.out.println(Math.floor(Math.sqrt(5)));

		System.out.println(solution(121));
	}
	private static long solution(long n) {
		if (Math.sqrt(n)-Math.floor((Math.sqrt(n)))>0) {
			return -1 ;
		}
		long a = (long) (Math.sqrt(n)+1);
		return (long) Math.pow(a,2);
	}

}
