/* 일반적인 객체를 ArrayList에 넣어서 테스트
 * 
 */

package mycollect;

import java.util.ArrayList;
import java.util.List;

public class ArraListTest_01 {

	public static void main(String[] args) {
	List <String> list1 = new ArrayList();  // 문자열만 들어가는 어레이 리스트	<> 안에는 기본자료형은 들어갈수 없다
	// Integer는 정수형 기본자료형인 int 를 객체화시킨 클래스
	List <Integer> list2 = new ArrayList();
	
	// C(add)  R(get)  U(set)   D(remove)
	// 인덱스를 이용해 데이터에 접근한다
	list1.add("역삼동");
	list1.add("상도동");
	list1.add("여의도동");
	list1.add("수유동");
	
	String temp = list1.get(3);
	System.out.println(temp);
	System.out.println("=========================================");
	list1.add(0,"양주시");  // 들어갈 위치 지정
	String temps = list1.get(0);
	System.out.println(temps);
	
	int count = list1.size();
	System.out.println(count);
	
	//전체순회
	
	for(int i=0;i<list1.size();++i) {
		System.out.println(list1.get(i));
	}
	System.out.println("========================================");
	// Advanced For -v2
	for(String t:list1 )
		System.out.println(t);
	
	System.out.println("============================================");
	// 람다식 생성법
	list1.forEach((t)->System.out.println(t));
	System.out.println("============================================");
	// 수정 하는 방법
	list1.set(2,"사랑동");
	list1.forEach((t)->System.out.println(t));
	System.out.println("============================================");
	
	String tmp =list1.remove(1);
	list1.forEach((t)-> System.out.println(t));
	System.out.println("삭제되어 반환된 데이터: "+ tmp);
	System.out.println("============================================");
	// 데이터 유무 확인
	boolean result = list1.contains("수유동");
	result = list1.contains("월계동");
	}
}
