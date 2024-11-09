/*
 * [문제]
 1~100 까지의 자연수중 3,5의 뱌구만 출력하시오 
 */
public class Exam_21 {

	public static void main(String[] args) {
		for (int i=1 ; i<=100 ;++i ) {
			if (!(i%3==0 && i%5 ==0)) {
				continue;
			}else System.out.println(i);
		}
			

	}

}
