/*
 * 문제 설명 [하샤드문제]
양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. 예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다. 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.

제한 조건
x는 1 이상, 10000 이하인 정수입니다.
 */
package month7;

public class Num_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(13));
		
	}
	private static boolean solution(int x) {
		String a= String.valueOf(x); // 문자열이됨 
		int b=0;
		for(int i=0;i<a.length();++i) {
			int c = Integer.parseInt(a.substring(i,i+1));
			b+=c;
		}
		return x%b == 0 ? true: false ;
		
	}
	// 람다식사용기반
	private static boolean answer1(int x) {
		int sum = String.valueOf(x).chars().map(ch ->ch-'0').sum();
		return x%sum == 0 ;
	}
	private static boolean answer2(int x) {
		String[] tmp= String.valueOf(x).split(""); // 문자열을 문자배열로 전환
		int sum=0;
		for(String y:tmp)
			sum+=Integer.parseInt(y);
		 return x%sum == 0;
	}
	
}
