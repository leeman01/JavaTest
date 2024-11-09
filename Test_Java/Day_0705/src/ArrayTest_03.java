
public class ArrayTest_03 {

	public static void main(String[] args) {
		String name= "이순신";
		String addr = new String("강감찬네 집"); //객체생성
		String [] sary1 = {"봄","여름","가을","겨울"}; 
		String [] sary2 = new String[] {"봄","여름","가을","겨울"}; //배열 만들기
		String[] sary3 = new String[] {new String("봄"),new String("여름"),new String("가을"),new String("겨울")};
		String[] sary4 =  {new String("봄"),new String("여름"),new String("가을"),new String("겨울")}; // String이 아닌
	}

}
