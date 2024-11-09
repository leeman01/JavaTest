package stacktest;

import java.util.Stack;

public class Stacktest_158p {

	public static void main(String[] args) {
		String a ="baabaab" ;
		System.out.println(solution(a));

	}
	// 스택문제에서는  peek나 pop를 하기 전 스택이 비어있는지 여부를 꼭 확인해야합니다 그렇지 않으면 EmptyStackException 문제가 발생
	private static int solution(String string) {
		//  만약 이전문자열과 현재문자열이 동일하면 기존에 있던 문자열을 제거하고 동일하지않으면 스택에 넣는 다는사실을 기억하자
		// => 스택문제의 핵심이라 볼 수 있을것이다
		Stack <Character> stack = new Stack<>();
		for(int i=0 ; i< string.length();++i) {
			Character c = string.charAt(i) ;
			if(!stack.isEmpty() && c==stack.peek()) {
				stack.pop();
			}else {
				stack.push(c);
			}
			
		}
		return stack.isEmpty() ? 1: 0 ;
		// if문을 사용하기 보다는 ?문을 사용하는데 익숙해지면 좋을듯하다
	}
}
