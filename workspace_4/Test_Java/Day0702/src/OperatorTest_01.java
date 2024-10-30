/*
 * 산술연산자(+ - * 나누기 %)
 */
public class OperatorTest_01 {

	public static void main(String[] args) {
		int a,b;
		int result;
		a=10;
		b=20;
		result = a / b ; // result= a/(double) b 이래도 result가 int라서 계산안됨
		System.out.println(result);
		a=10;
		b=3;
		result = a % b;
		System.out.println(result);
		
		result = 10*(20/5);
		System.out.println(result);
		
		// +연산의 특징: 단향, 이항, 결합
		int x = 10 ;
		x = + - - + - x; // 원래 부호를 유지, 부호를 바꿀거면 -를 사용하면 된다,부호끼리는 띄워 써야한다
		System.out.println(x);
		
		result = 10+30;
		String temp = "값" + 10 ; // 이때 10은 숫자가 아니라 +로 연결되어 문자열로  바뀐다
		
		temp= "올해는" +2024 + "년";// "올해는 2024" + "년" => "올해는 2024년"
		
		temp = "당신의 나이는" + (2024-1991);
		System.out.println(temp);

	}

}
