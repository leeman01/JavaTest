/*
 * [문제] 알파벳 소문자 삼각형 만들기
 */
public class Exam_22 {

	public static void main(String[] args) {
		for ( char i ='a' ; i<='z' ; ++i) {
			for (char j='a'; i>=j; ++j) {
				System.out.print(j);
			}System.out.println();
		} 
			
		
		
	}

}