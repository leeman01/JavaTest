/* * [문제] 키와 몸무게를 설정한 후 BMI (체질량 지수)를 구허여 출력하시오
 * "당신의 키 174cm, 몸무게 67kg은 ~bmi 입니다"
 * bmi = 몸무게 /키 의 제곱
 */
public class Sixth {
	public static void main(String[]args) {
		double key = 174;
		double weg = 67 ;
		double square= (key*0.01)*(key*0.01);
		double bmi = (weg/square);
		System.out.println( bmi);
		System.out.println("키 174 몸무게 67의 bmi:"+ bmi);
		System.out.printf("키 %.0fcm, 몸무게 %.0f KG의 bmi %.2f",key,weg,bmi);
	}

}
