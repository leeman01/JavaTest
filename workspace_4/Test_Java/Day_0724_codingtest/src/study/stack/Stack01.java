package study.stack;

import java.util.Stack;

public class Stack01 {

	public static void main(String[] args) {
		// 최근에 삽입한 데이터로 무언가 작업을 진행할 경우 스택을 떠올려보자
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println("스택이 비었는지 여부를 확인: " +stack.isEmpty());
		System.out.println("첫번째 pop: " + stack.pop()); 
		System.out.println("2번째 pop: "+ stack.pop());
		
		Stack <Integer> stack1 = new Stack<>();
		stack1.push(5);
		stack1.push(6);
		// 가장최근에 푸시한값
		System.out.println(stack1.peek());
		System.out.println(stack1.pop());
		// 스택에 들어있는 데이터의 개수
		System.out.println(stack1.size());
		stack1.push(7);
		stack1.push(14);
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.size());
		// 스택의 개념은 어렵지 않지만 어느경우에 스택을 활용해야할지 잘 몰라 틀리는 경우가 많다 이 점을 유의하자
	}

}
