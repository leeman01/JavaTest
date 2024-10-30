/*
 * JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다.
 *  단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다.
 *   (첫 번째 입출력 예 참고)
문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.

제한 조건
s는 길이 1 이상 200 이하인 문자열입니다.
s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.
숫자는 단어의 첫 문자로만 나옵니다.
숫자로만 이루어진 단어는 없습니다.
공백문자가 연속해서 나올 수 있습니다.
 */
package month7;

import java.util.Arrays;

public class Num_31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("people unFolloed me"));

	}
	// 와 이런 생각을 하네 .... 여기에서 문자열에 true false 둘중 하나의 값을 더함
	// 이로인해 문자열이 true false인지 판명함으로 
	private static String solution(String s) {
		String str = "" ;
		String[] a = s.toLowerCase().split("");
		boolean flag = true ;
		for(String ss:a) {
			str+=flag ? ss.toUpperCase() : ss;
			flag = ss.equals(" ") ? true : false ;
 		}
		return str ;
	}

}
