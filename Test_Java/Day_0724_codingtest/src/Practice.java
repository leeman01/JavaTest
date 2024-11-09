import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] ary = {2,1,2,3,4,4,4,5};
		System.out.println(Arrays.toString(solution1(ary)));
		System.out.println(Arrays.toString(solution2(ary)));
	}
	// 0806  158p 연습
	private static int solution(String s) {
		Stack <Character> stack = new Stack<>();
		for(int i=0;i<s.length();++i) {
			Character c = s.charAt(i);
			if(!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
			}else {
				stack.push(c);
			}
		}
		return stack.isEmpty() ? 1:0 ;
	}
	private static int[] solution1(int[] array) {
		Set <Integer> set = new HashSet<>();
		// 중복값제거는? => HashSet
		for(int i: array) {
			set.add(i);
		}
		return set.stream().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
				
	}
	private static int[] solution2(int[] arry) {
		// 중복값 처리? => 더해서 값이 몇개가 나올것인지는 모른다 
		Set<Integer> set = new HashSet<>(); 
		for(int i=0;i<arry.length-1;++i) {
			for(int j=0;j<arry.length;++j) {
				set.add(arry[i]+arry[j]); // 값 더하기
			}
		}
		
		
		return set.stream().sorted().mapToInt(Integer::intValue).toArray();
		
	}
	private static int[] solution3(int N,int [] stages) {
		// 몇단계에서 몇명이 실패했는지 부터 알아보자
		int total = stages.length ;
		int[] answer = new int[N+2];
		for (int i=0;i<stages.length;++i) {
			if(stages[i]==i+1)
				answer[stages[i]]+=1;
		}
		// 몇명이 실패한지 파악
		
		// 실패율 정의
		double [] defeat = new double [N+2];
		for(int i=1;i<total;++i) {
			defeat[i]=(double)answer[i]/total;
			total-=answer[i];
		}
		HashMap<Integer,Integer> map = new HashMap<>();
		for (int i=0; i<answer.length;++i) {
			map.put(i+1, answer[i]);
		}
		return 
		
	
	
	}
	
}
