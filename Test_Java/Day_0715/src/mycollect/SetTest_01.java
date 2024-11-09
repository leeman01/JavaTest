package mycollect;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest_01 {

	public static void main(String[] args) {
		Set <String> set = new HashSet<>();
		
		set.add("포도");
		set.add("사과");
		set.add("오렌지");
		set.add("자두");
		set.add("바나나");
		
		// 1) 전체조회
	set.forEach((fruit)->System.out.print(fruit + " "));
	System.out.println();
	// 2) 데이터조회
	boolean result =set.contains("오렌지");
	System.out.println(result);
	
	// 3) 삭제
	result = set.remove("오렌지");
	System.out.println(result ? "삭제성공": "삭제실패");
	
	int count = set.size();
	System.out.println("Set 데이터 개수: " + count);
	
	result =set.add("바나나");
	System.out.println(result ? "추가성공": "추가실패");
	
	// 4)  Iterator를 사용한 전체조회
	Iterator <String> iter = set.iterator();
	// iter 객체타입은 for문사용 x
	while (iter.hasNext()) {
		System.out.print(iter.next()+ " ");
	}
	System.out.println();

	
	}

}
