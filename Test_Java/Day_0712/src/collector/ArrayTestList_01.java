package collector;

import java.util.ArrayList;

public class ArrayTestList_01 {

	public static void main(String[] args) {
		// generic을 저장해서 ArrayList에 들어갈 객체 타입 설정
		ArrayList <String> slist = new ArrayList<>();
		slist.add("아이스 아메리카노");
		slist.add("카푸치노");
		slist.add("카페라떼");
		slist.add("녹차라떼");
		System.out.println("데이터의 개수: " + slist.size());
		// 중요하다
		slist.add(1,"더치커피");
		System.out.println(slist); // toString이 자동으로 호출되어 문자열로 출력
		System.out.println(slist.get(2));
		System.out.println(slist.contains("과일빙수"));
		System.out.println(slist.isEmpty()); //데이터가 있으니까 False'
		System.out.println(slist.remove(0)); // 삭제된 데이터를 반환
		System.out.println(slist.remove(0)); // 삭제된 데이터로 초기화된 리스트 0번째를 지움
		System.out.println(slist.remove("아이스 아메리카노"));
		slist.clear();
		System.out.println("데이터의 개수: " + slist.size());
	}

}
