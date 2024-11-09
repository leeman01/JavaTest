/*
 * 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. 
 * str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 
 * 문자열을 반환하는 함수, solution을 완성하세요.
예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.

제한 조건
s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
 */
package month7;

import java.util.Arrays;

public class Num_27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("-1 -2 -3 -4"));

	}
	private static String solution(String s) {
		String[] str = s.split(" ");
		int [] a = new int[str.length];
		for(int i=0;i<str.length;++i) {
			a[i] = Integer.parseInt(str[i]); // 숫자가 담김
		}
		Arrays.sort(a);

		return  a[0] + " " + a[a.length-1] ;
		
			
	}
	private static String answer(String str) {
		String [] tmp = str.split(" ");
		int min , max , n ;
		min = max = Integer.parseInt(tmp[0]);
		for(int i=1 ; i<tmp.length;++i) {
			n= Integer.parseInt(tmp[i]);
			if(min > n) min = n;
            if(max < n) max = n;
        }

        return min + " " + max;
			
		}
		
	}


