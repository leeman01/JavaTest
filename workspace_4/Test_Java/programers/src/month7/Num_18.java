/*
 * 문제 설명
프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 
숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.

제한 조건
phone_number는 길이 4 이상, 20이하인 문자열입니다.
 */
package month7;

public class Num_18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "027778888";
		System.out.println(solution(a));

	}
	// 반복적으로 문자열 객체를 만들어 내기 때문에 비효율적인 부분이 존재한다
	private static String solution(String phone_number) {
		String a ="";
		for (int i=1 ; i<=phone_number.length()-4;++i)
			a+="*";
		return a+ phone_number.substring(phone_number.length()-4,phone_number.length());
	}
	// char배열을 사용하여 메모리를 더 효율적으로 사용할 수 있게끔한다
	private static String answer(String phone) {
		char[] ch = phone.toCharArray();
		for(int i=0;i<ch.length-4;++i)
			ch[i]='*';
		return String.valueOf(ch);
	}

}
