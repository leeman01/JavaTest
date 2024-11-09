package stringapi;

public class StringTest_02 {

	public static void main(String[] args) {
		String str= "i have a dream. a song to sing!";
		// 문자열의 길이를 구하여 반환
		int a = str.length();
		System.out.println("문자열의 길이: " + a);
		
		// 전달된 인덱스위치의 문자1개를 반환
		char ch =str.charAt(0);
		System.out.println(ch);
		System.out.println("=====================");
		// compareto :문자열과 인덱스가 완전히 일치하면 0 아니면 틀린 //  두문자열을 비교서 str1의 캐릭터가 str2보다 유니코드 값이 크면 양수 작으면 음수값이나옴
		String str1 = "Zbcd";
		String str2 = "abcd";
		a= str1.compareTo(str2);
		System.out.println(a);
		// concat: 문자열 연결
		str1= "이동건";
		str2 = "박병우";
		String b= str1.concat(str2);
		System.out.println("concat(): " +b);
		//contains : 문장 포함여부확인
		str1="사과";
		str2= "사과망고";
		boolean c = str2.contains(str1);
		System.out.println("contains() : " + c);
		
		// endsitch : 문자열이 지정된 문자로 끝나는지확인 / 
		str1 = "이동";
		str2 = "dl";
		System.out.println("endswith() : " + str1.endsWith(str2));
		//  equals : 객체끼리 동일한거 확인
		str1="동";
		str2="동";
		System.out.println("equals(): " + str1.equals(str2));
		
		// indexof : 문자가 포함된 최초의 인덱스 반환
		char e = 'a';
		System.out.println("indexof(): " +str.indexOf((int)e));
		// isempty 비었는지  / 스페이스바 (띄워쓰기)가 있으면 안에있는걸로 인식해 false가 나온다
		System.out.println("isEmptyof(): " + str.isEmpty());
		// lasdindexof : 마지막 캐릭터 값 인덱스반환
		System.out.println("lasrIndexOf() : " + str.lastIndexOf((int)e));
		//replace = 파이썬 리플레이스와 동일// String의 원본은 수정이 불가능하다(immutable)
		str2 = "이동건";
		str2 = str2.replace('건', '껀');
		System.out.println("replace() : " +str2);
		// split  문자를 쪼갠걸 리스트 형식으로 저장함 그래서 출력하려면 어드밴스 포문 사용
		String test = "981127-1047715";
		String [] stt = test.split("-");
		String s = stt[0];
		char Q = s.charAt(0);
		System.out.println(Q);
		System.out.println("데이터의 개수: " + stt.length);
		for(String i : stt ) {
			System.out.println(i);
		}
		System.out.println("======");
		// substring : 입력한 숫자 인덱스부터 시작해서 문자열입력
		String str3 = "서울시 동작구 사랑동";
		System.out.println(str3.substring(4));
		// substring : 끝나는 숫자입력되면 거기까지 입력하는 거임
		// tolower 모두 소문자로 만들기 그럼 upper는 모두 대문자
		str1="ABVD";
		System.out.println(str1.toLowerCase());
		// trim : 문장의 앞과 끝의 스페이스바 없애기
		str1="A c  d       ";
		System.out.println(str1.trim());
		str1= str1.trim();
		System.out.println(str1+str2);
		String z = "1";
		
	}
}
