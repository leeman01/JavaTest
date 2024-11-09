package study;

public class StringBuilder_study {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("java");
		sb.append("Program Study");
		System.out.println(sb.toString());
		
		sb.insert(4, 2); // 인덱스 4위치에 숫자 2를 넣어라
		System.out.println(sb.toString());
		sb.setCharAt(2,'6');
		System.out.println(sb.toString());
		sb.replace(6, 13, "Book"); // 인덱스위치 6~13 까지의 문자를 book으로 바꿔라
		System.out.println(sb.toString());
		sb.delete(4, 5);
		System.out.println(sb.toString());
	}

}
