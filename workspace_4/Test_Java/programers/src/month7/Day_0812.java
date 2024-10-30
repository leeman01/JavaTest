package month7;
/*
 * 문제 설명
대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.

예를 들어 s가 "pPoooyY"면 true를 return하고 "Pyy"라면 false를 return합니다.

제한사항
문자열 s의 길이 : 50 이하의 자연수
문자열 s는 알파벳으로만 이루어져 있습니다.
 */
public class Day_0812 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("pyyyy"));
		

	}
	

	public static boolean solution(String s) {
		int cnt = 0; 
		int cnt1=0;
		for (int i=0;i<s.length();++i) {
			if(s.charAt(i)=='p') {
				cnt+=1;
			}else if (s.charAt(i)=='y') {
				cnt1+=1;
			}
		}
		return cnt==cnt1 ? true: false ;
	}
	// 다른 사람들 풀이
	private boolean solution1(String s) {
		s=s.toUpperCase();
		return s.chars().filter(e->'P'==e).count() == s.chars().filter(e->'Y'==e).count(); // 람다식을 활용한 풀이
	}
}
