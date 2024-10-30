package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class CollectioStude_day0804 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list1 = new ArrayList(10);
		list1.add(new Integer(5)) ;	
		list1.add(new Integer(4)) ;	
		list1.add(new Integer(0)) ;	
		list1.add(new Integer(1)) ;	
		list1.add(new Integer(3)) ;
		list1.add(new Integer(2)) ;
		ArrayList list2 =new ArrayList(list1.subList(1, 4)) ;
		
		Collections.sort(list1);
		Collections.sort(list2);
		
		System.out.println(list2.containsAll(list1));
		System.out.println(list1.containsAll(list2));
		
		list2.add("B");
		list2.add("C");
		list2.add(3,"A"); // 위치가 3인곳에 A값 저장
		
		list2.set(3, "AA"); // 리스트가 3인곳을 AA로 바꿈
		
		System.out.println(list1.retainAll(list2)); // 겹치는 부분만 빼고 모두 삭제하기
		
		for (int i= list2.size() -1 ; i>=0 ; --i) {
			if(list1.contains(list2.get(i)))
				list2.remove(i); // 인덱스를 기준으로 겹츠는 것 삭제
		}
		// 스택과 쿼리의 예제
			
		Stack st = new Stack();
		Queue q =new LinkedList<>();
		
		st.push("0");
		st.push("1");
		st.push("2");
			
		q.offer("0");
		q.offer("1");
		q.offer("2");
		while (!st.empty()) {
			System.out.println(st.pop());
		}
			
		while (!q.isEmpty()) {
			System.out.println(q.poll());
		}
			
			
			
		int[] arr = new int[5];
	
		Arrays.setAll(arr,i -> (int)(Math.random()*100+5));
		
			
		int [] arr1 = {3,2,0,1,4};	
		Arrays.sort(arr1);
		System.out.println(arr1.toString());
			
		
		
		
		Set set = new HashSet();		
		for (int i=0 ; set.size() <6 ;++i) {
			set.add((int)(Math.random()*100+5));
		}
		set.forEach(i-> System.out.println(i));
		
		List list = new ArrayList(set) ;
		Collections.sort(list);
		System.out.println(list);
		
		
		
			
		}
		
}