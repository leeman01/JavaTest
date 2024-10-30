package stringbufferapi;

public class StringBufferTest_92 {

	public static void main(String[] args) {
//		String str = new String("무궁화 꽃");
//		str = str.concat("이 피었습니다."); // str이 다시 수정된 곳을 참조하도록 해야한다 그렇다면? str의 무궁화꽃 데이터는 없어짐
//		System.out.println(str);
		StringBuffer buff2 = new StringBuffer("roEHd");
		StringBuffer buff1 = new StringBuffer("무궁화 꽃");
		// 용량체크
		System.out.println("buff1의 용량: " + buff1.capacity());
		
		buff1.append("이 피었습니다.");
		System.out.println(buff1);
		
		buff1.append(false);
		buff1.append(25); // 여러가지 데이터를 붙일수있다
		System.out.println(buff1.charAt(4));
		System.out.println(buff1);
		
		buff1.insert(0,"산과들에");
		System.out.println(buff1);
		
		buff1.delete(3,4);
		System.out.println(buff1);
		
		buff1.replace(3,6,"장미");
		System.out.println(buff1);
		System.out.println("buff1의 용량: " + buff1.capacity());
		buff1.trimToSize();
		System.out.println("buff1의 용량: " + buff1.capacity()); // 실제글자가 몇개인지 파악
		
		buff1.reverse();
		System.out.println(buff1);
		buff1.trimToSize();
		
		String temp = buff1.toString();
		System.out.println(temp);
		System.out.println(temp.getClass());
		System.out.println(buff1.getClass());
	}
}
