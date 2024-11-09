import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest_01 {

	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<>();  
		// key는 set 으로 중복된 데이터가 없다
		// 인덱스가 없다 , 데이터에 접근하기 위해서는 키를 이용해 접근
		// 데이터가 순서없이 들어감
		// 다량의 데이터를 조회할 때 list보다 성능이 좋음

		// put() 으로 값을 넣고 get으로 호출함
		
		// 데이터 넣기 C (create)
		map.put(1,"이순신");
		map.put(2,"강감찬");
		map.put(3,"권율");
		map.put(4,"김유신");
	
		// R (retrieve)
		String find = map.get(4); // 이떄의 4는 인덱스가 아닌 key값이다
		System.out.println(find);
	
		// size() : 데이터의 개수
		int count = map.size();
		System.out.println("데이터의 총개수 : " + count );
		
		// Update
		String temp = map.replace(4, "홍범도");
		System.out.println(temp);  // 바뀌기전 김유신이 나옴
		
		System.out.println(map);
		
		temp =map.put(3, "맥아더");
		
		System.out.println(temp);
		
		System.out.println(map);
		
		// 조회 (검색)
		boolean result = map.containsKey(5);
		
		System.out.println(result ?  "5번있음" : "5번없음");
		
		result = map.containsValue("김구");
		
		System.out.println(result ?  "김구있음" : "김구없음");
		
		// 삭제
		
		String removedData = map.remove(1);
		System.out.println("삭제 처리된 사람: " + removedData);
		
		// 데이터 전체조회
		
		Set<Integer>keys = map.keySet();
		
		// 키목록을 이용해 interator  객체생성
		Iterator <Integer> iter = keys.iterator();
		
		//  map.keySet().iterator(); 식으로 처리가능
		
		while(iter.hasNext()) {
			Integer key =iter.next();
			System.out.println(key + ":"+map.get(key));
		}
		
		
		
	}
}
