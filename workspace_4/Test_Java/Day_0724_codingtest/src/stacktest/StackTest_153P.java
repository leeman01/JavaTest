package stacktest;

import java.util.HashMap;
import java.util.Stack;

public class StackTest_153P {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a ="()()()({})))[]" ;
		System.out.println(solution(a));

	}
	private static int solution(String s) {
		int answer=0;
		// 일단 Stack 타입을만든다  
		HashMap <Character,Character> map = new HashMap<>();
		Stack <Character> stack = new Stack<>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		for(int i=0; i<s.length();++i) {
			Character c = s.charAt(i);
			if (!map.containsKey(c)) {
				stack.push(c);
			}else {
				if(stack.isEmpty() || !stack.pop().equals(map.get(c))) {
					continue;
				}
				answer++;
			}
			
			
		}
		return answer;
	}
}
