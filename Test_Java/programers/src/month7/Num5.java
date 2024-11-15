/*
 * 문제 설명

함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를들어 n이 118372면 873211을 리턴하면 됩니다.

제한 조건
n은 1이상 8000000000 이하인 자연수입니다.
 */

package month7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Num5 {

	public static void main(String[] args) {
		System.out.println(solution2(12394));

	}
	private static int solution(long n) {
		ArrayList <Integer> arraylist = new ArrayList<>();
		int answer =0 ;
		while(true) {
			answer = (int) (n%10);
			arraylist.add(answer);
			if (n<10)
				break;
			n /=10;
		} // arraylist에 각 자릿수들이 모두 담김
		int [] list = arraylist.stream().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray() ; // 숫자가 큰 걸로 어레이 리스트 만듦
		String a="" ;
		for(int i=0;i<list.length;++i) {
			a+=list[i];
		}
		return Integer.parseInt(a);
	}
	private static long solution2(long n) {
        // 숫자를 문자열로 변환하고, 이를 문자 배열로 변환
        char[] digits = Long.toString(n).toCharArray();

        // 문자 배열을 내림차순으로 정렬
        Arrays.sort(digits);

        // 내림차순 정렬이므로, 배열을 뒤집어야 함
        StringBuilder sb = new StringBuilder(new String(digits));
        sb.reverse();

        // 최종 문자열을 long 타입으로 변환하여 반환
        return Long.parseLong(sb.toString());
    }
}


