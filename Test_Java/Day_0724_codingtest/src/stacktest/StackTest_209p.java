package stacktest;

import java.util.ArrayDeque;
import java.util.Arrays;

public class StackTest_209p {

	public static void main(String[] args) {
		String[] s1 = {"i","want","water"};
		String[] s2 = {"to","drink"};
		String[] s3 = {"i","want","to","drink","water"};
		System.out.println(solution(s1,s2,s3));
	}
	private static boolean solution(String [] s1,String[] s2,String [] answer) {
		
		ArrayDeque<String> target1 = new ArrayDeque<>(Arrays.asList(s1));
		ArrayDeque<String> target2 = new ArrayDeque<>(Arrays.asList(s2));
		ArrayDeque<String> answer1 = new ArrayDeque<>(Arrays.asList(answer));
	while(!answer1.isEmpty()) {
		if (!target1.isEmpty() && target1.peekFirst().equals(answer1.peekFirst())) {
			target1.pollFirst();
			answer1.pollFirst();
		}else if(!target2.isEmpty() && target2.peekFirst().equals(answer1.peekFirst())) {
			target2.pollFirst();
			answer1.pollFirst();
		}else {
			break;
		}
	}
	return answer1.isEmpty() ?  true : false ;
		
	}

}
