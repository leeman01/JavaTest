package stacktest;

import java.util.ArrayDeque;
import java.util.Stack;

public class StackTest_144p {

	public static void main(String[] args) {
		String a ="(())";
		System.out.println(solution(a));
	
	}
	// 정답이다
	private static boolean solution(String array) {
//		Stack <String> stack = new Stack<>();
		//  ArrayDeque 클래스를 사용하여 Character 타입의 스택을 생성하는 코드입니다. 
		ArrayDeque<Character> stack = new ArrayDeque<>();
		char[] a = array.toCharArray();		
		for(char c:a) {
			if 	(c=='(') {
				stack.push(c);
			}
			else {
				if(stack.isEmpty() || stack.pop()==c) {
					return false;
				}
			}
		}
			
		return stack.isEmpty() ;
	}

}
