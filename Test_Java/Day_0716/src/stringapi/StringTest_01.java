package stringapi;

public class StringTest_01 {

	public static void main(String[] args) {
		// String class 객체 생성하는 다양한 방법
		String str1 = "korea";
		String str2 = new String(); // String 기본생성자로 만드는 방법
		String str3 = new String("japan");
		System.out.println(str1 + "," + str2 + "," + str3);
		
		// 기존의 데이터를 이용한 객체 생성
		char[] ch= {'오','늘','은','화','요','일'};
		int [] iAry = {65,97,66,98,67};
		
		String str4 = new String(ch);
		String str5 = new String(iAry,0,4); // 배열이름을 주고 시작위치와 끝 위치 인덱스를 넣어야함
		System.out.println(str4);
		System.out.println(str5);
	}

}
