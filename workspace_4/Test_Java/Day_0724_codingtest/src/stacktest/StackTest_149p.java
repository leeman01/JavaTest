package stacktest;

import java.util.Stack;

public class StackTest_149p {

	public static void main(String[] args) {
		System.out.println(solution(12345));
		
	}
	// 2진수로 저장된걸 역순으로 출력하는 점과 이진수 공식에 대해 인지하자
	private static String solution(int a) {
		Stack <Integer> stack = new Stack<>();
		while(true) {
			int q = a%2 ; // 나머지 구하기
			stack.push(q);
			 a= a/2 ; //  몫 구하기
			
			if (a==0) {
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		return sb.toString();
		
	}

}
