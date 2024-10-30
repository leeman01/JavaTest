/*
 * [문제] 키를 지정한 후 표준체중을 구하시오!
 * 남성표준체중 = 키(m) * 키 *22
 * 여성표준체중 = 카 * 키 * 21
 */
public class Exam_01 {
	public static void main(String[] args) {
		double key = 170;
		double key1 = 170 * 0.01;
		double output = key1 * key1* 22;
		System.out.printf("키가 %.1f 인 당신의 표준체중은 %.2f 입니다",key,output);
		System.out.println();
		double height = 176.5;
		double std ; // 변수를 선언만 함
		double temp = height *0.01;
		std = temp * temp * 22;
		System.out.printf("키가 %.2fcm 의 표준체중은 %.2f kg이다 ",height,std);
		System.out.println();
	}
}

