package stacktest;

import java.util.Arrays;
import java.util.Stack;

public class Stacktest_161p {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] prices = {1,2,3,2,3};
		int [] answer = solution(prices);
		int [] answer1 = solution2(prices);
		System.out.println(Arrays.toString(answer));
		System.out.println(Arrays.toString(answer1));
	}
	// 이런식으로 풀어도 좋지만 효율성 테스트에서 통과하지못할 가능성이 있다 => 답지를 참고해서 무엇이 부족한지 파악하자
	
	private static int [] solution(int[] array) {
		int [] answer = new int [5];
		Stack <Integer> stack = new Stack<>();
		for(int i=0;i<array.length;++i) {
			int cnt=0;
			stack.push(array[i]);
			for(int j=i+1 ; j<array.length;++j ) {
				if(stack.peek()-array[j]<1)
					cnt+=1;	
			}
			array[i]=cnt;
		}
		
		return array;
	}
	private static int [] solution2(int [] array) {
		int n = array.length ;
		int []answer =new int[n] ;
		Stack <Integer> stack = new Stack<>();
		stack.push(0); // 인덱스값
		for(int i=1;i<n;++i) {
			while(!stack.isEmpty()&&array[i]<array[stack.peek()]) {
				int j =stack.pop();
				answer[j]=i-j;
			}
			stack.push(i);
		}
			while(!stack.isEmpty()) {
				int j = stack.pop();
				answer[j]=n-j-1;
			}
		return answer;
	}
}
