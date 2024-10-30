package stringbufferapi;

public class StringTest {

	public static void main(String[] args) {
		String str1 = "Hello world" ;
		String str2 = "Hello world" ;
		String str3 = new String("Hello world") ;
		
		// 내용비교 (equals)
		if (str1.equals(str3)) System.out.println("내용이같다");
		if (str1.equals(str2)) System.out.println("내용이같다");
		//주소비교 (==)
		if (str1==str2) System.out.println("주소가 같다 1,2");
		if (str1==str3) System.out.println("주소가 같다 1,3");
		
		// =====================================================
		
		StringBuffer b1 = new StringBuffer("Hello world");
		StringBuffer b2 = b1.append("~~~~");
		System.out.println("내용비교 :" + b1.equals(b2));
		System.out.println("주소비교 :" +(b1 == b2)) ;
		
		
		
		
		
		
		
	}

}
