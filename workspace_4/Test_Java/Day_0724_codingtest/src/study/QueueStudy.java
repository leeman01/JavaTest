package study;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueStudy {

	public static void main(String[] args) {
		Queue <Integer> queue = new ArrayDeque<>(); // 큐를 구현하기 위한 arraydeque객체 생성
		queue.add(1);
		queue.add(2);
		queue.add(3);
		int first = queue.poll();
		System.out.println(first);
		
		queue.add(4);
		queue.add(5);
		System.out.println(queue.poll());
		
		// 덱을 큐처럼활용하기 
		ArrayDeque<Integer> queque = new ArrayDeque<>();
		
		queque.addLast(1);
		queque.addLast(2);
		queque.addLast(3);
		System.out.println(queque.pollFirst());
		
		queque.addLast(1);
		queque.addLast(2);
		queque.addLast(3);
		System.out.println(queque.pollFirst());
		
	}

}
