package myenum;

public class EnumTest_02 {

	public static void main(String[] args) {
		Season2 s = Season2.여름;
		System.out.println(s);
		System.out.println(s.getData()); // getData하면 매칭된 문자를 반환
		
		System.out.println(Season2.가을.getData());
	}

}
