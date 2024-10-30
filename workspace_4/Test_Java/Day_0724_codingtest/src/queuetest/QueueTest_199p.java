package queuetest;

import java.util.ArrayDeque;

public class QueueTest_199p {

	public static void main(String[] args) {
		System.out.println(solution(5,2));

	}
	private static int solution(int n,int k) {
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for(int i=1 ; i<=n;++i) {
			deque.addLast(i);
		}
		while(deque.size()>1) {
			for (int i=0;i<k-1;i++) {
				deque.addLast(deque.pollFirst());
			}
			deque.pollFirst() ;
		}
		return deque.pollFirst() ;
	}
}
