/*
 * 문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.

제한 사항
s는 길이 1 이상, 길이 8 이하인 문자열입니다.
s는 영문 알파벳 대소문자 또는 0부터 9까지 숫자로 이루어져 있습니다.
 */
package month7;

public class Num_25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(anser("aaaa"));
		System.out.println('1'-'0');
	}
	private static boolean solution(String s) {
		if(!(s.length()==6||s.length()==4)) 
			return false;
		for(int i=0;i<s.length();++i) {
			Character c = s.charAt(i);
			if((c-'0'>9)) {
				return false ;
			}
		}
		return true ;
	
	}
	// try ~catch를 이용한 풀이방법
	private static boolean anser(String s) {
		if((s.length()==6||s.length()==4)) {
			try {
				int x = Integer.parseInt(s);
				return true ;
			}catch(NumberFormatException e) {
				return false;
			}
		}
		return false;
	}

}
