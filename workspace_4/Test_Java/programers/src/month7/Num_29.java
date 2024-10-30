/*
 * 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어

"()()" 또는 "(())()" 는 올바른 괄호입니다.
")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
'(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 
올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
 */

package month7;

import java.util.Stack;

public class Num_29 {

	public static void main(String[] args) {
		System.out.println(solution("()()()"));

	}
	private static boolean solution(String s) {
		Stack <Character> st = new Stack<>();
		
		st.push(s.charAt(0));
		for(int i=1; i< s.length();++i) {
			
		
			if((st.isEmpty()) || st.peek()==s.charAt(i)){
				st.push(s.charAt(i));
			}else if(!(st.isEmpty()) && st.peek() != s.charAt(i)){
				st.pop();
			
			}
		}
		
		
		return st.isEmpty() ? true : false ;
	}

}
