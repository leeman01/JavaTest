package stringbufferapi;

public class SttringBufferTest_01 {

	public static void main(String[] args) {
		StringBuffer buff1 = new StringBuffer();  // java.lang 내부의 클래스는 import 하지않음
		System.out.println("buffer 공간: " + buff1.capacity()); // 16개의 공간
		
		StringBuffer buff2 = new StringBuffer("나리 나리 개나리 입에따다 물고요.");
		System.out.println("buffer2 공간: " + buff2.capacity());
		
		StringBuffer buff3 = new StringBuffer(new StringBuffer("손오공 근두운타고 놀러갑니다.")); // 캐릭터 시퀀스의 자식은 string,Stringbuffer라서 가능하다
		StringBuffer buff4=new StringBuffer(100);
		System.out.println("buffer4 공간: " + buff4.capacity()); 
	}

}
