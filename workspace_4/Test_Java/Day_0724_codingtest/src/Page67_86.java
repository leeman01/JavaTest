import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Page67_86 {

	public static void main(String[] args) {
		int a=13;
		int b=4;
		System.out.println("a+b:"+  (a+b));
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
		System.out.println(a%b);
		System.out.println( a|b);
		System.out.println(a<<2); // 13 * 2의 2승과 동일하다
		System.out.println(a>>2); // 13 / 2^2와 동일하다
		System.out.println(a^b);
		// 앱실론 출력=> 부동소수형 비교할 때 주의하자
		double epsilon = 1E-5;
		double c = 0.1+0.2;
		double d = 0.3;
		System.out.println("c-d: "+ (c-d));
		if(a==b) {
			System.out.println("c와d는 같은 값");
		}else 
			System.out.println("c와d는 다른값"); // 부동 소수점을 비교할 때는 이점을 주의하자
		
		if (Math.abs(c-d) < epsilon) {
			System.out.println("c와 d는 같은값");
		}else
			System.out.println("둘은 다른값이다");
		// 다음과 같은 결론이 나는 이유는 c d의 소수를 이진수로 완벽히 표현하지 못해 0.3000004 정도의 값이 나온다
		// 그러므로 == 문제에서는 틀리다는 값이 나오지만, 적은값 엡실론과 비교하면 맞다는 값이 나온다
		
		// 배열 문제
		int [] array = {1,2,3,4,5};
		int [] array2 = new int[] {1,3,5,7,9};
		int [] array3 = new int[5];
		
		array3[0]=0;
		array3[1]=2;
		array3[2]=4;
		array3[3]=6;
		array3[4]=8;
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(array2));
		System.out.println(Arrays.toString(array3));
		
		int [] myarray = {1,2,3,4,5};
		myarray[1]=7;
		System.out.println(Arrays.toString(myarray)); // 값이 변경
		System.out.println(myarray[1]);
		
		myarray[4]=myarray[2];
		System.out.println(Arrays.toString(myarray));
		
		// 리스트 객체 구현
		ArrayList <Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(6);
		System.out.println(list.get(2));
		System.out.println(list);
		
		// 키와 벨류값을 가진 헤시맵 구현하기
		HashMap<String,Integer> map = new HashMap<>();
		
		map.put("사과", 1);
		map.put("바나나", 2);
		map.put("오렌지", 3);
		System.out.println(map);
		
		// 해시 맵 활용하기
		String key = "사과";
		if (map.containsKey(key)) {
			int value = map.get(key);
			System.out.println(key + ":" + value);
		}else
			System.out.println("해시맵에 없는 키입니다");
		
		// 해시맵 수정 => 기존에 있던 키값에 새로운 값을 넣어주면 수정된다
		map.put("바나나", 56);
		System.out.println(map);
		
		// 해시맵 삭제
		map.remove("바나나");
		System.out.println(map);
		
		// 해시맵 객체 생성 
		HashMap<String ,Integer> map1= new HashMap<>();
		map1.put("apple", 1);
		map1.put("banana", 2);
		map1.put("cherry", 3);
		
		String key1 = "orange";
		if (map.containsKey(key1)) {
			System.out.println("유효한 키");
		}System.out.println("없는 키");
		
		// 문자
		String str = "Hello World";
		
	}
}
