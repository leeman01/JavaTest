/*
 * [문제] 키를 지정한 후 표준체중을 구하시오!
 * 남성표준체중 = 키(m) * 키 *22
 * 여성표준체중 = 카 * 키 * 21
 * ============================================
 * 몸무게(KG)을 지정한 후 BMI 를 구하시오
 * BMI = 몸무게 / 키(M)의 제곱
 */
public class Exam_02 {
	public static void main(String[] args) {
		double key = 176.5;
		double weg = 72.4;
		double std,bmi ;           
		double temp = key / 100;
		double output = weg / (temp * temp);
		
		System.out.printf("키가 %.2fcm 의 BMI는 %.2f kg이다",key,output);
		System.out.println();
	}
}

