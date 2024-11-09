package ecpttest;

public class ExceptionTest_01 {

	public static void main(String[] args) {
		String [] str = {"3","7","a"};
		String a = str[0]; // 문자열 1 가져오기
		int b = 3;  // "1" +3  ==> 13이라는 문자열 // "1" * 3 값이 나오게 하고싶음 => 구문분석을해야한다
		// Integer.parsrInt("1")  ;  구문분석이 되면 숫자 1을 반환한다
		int c =Integer.parseInt(a);
//		int result = c*b;
//		System.out.println(result);
	try {
		int num1 = Integer.parseInt(str[0]);
		int num2 = Integer.parseInt(str[1]);
		int num3 = Integer.parseInt(str[2]); // 문자를 숫자로 구문분석하기 때문에 발생하는 오류
		int num4 = Integer.parseInt(str[3]); //ArrayIndexOutOfBoundsException
		
		int result = num1 / num2; // / by zero 0으로 나눠서 발생하는 오류
		
		System.out.println("처리결과: " + result);
	}catch (NumberFormatException e) {
		 e.printStackTrace();  // 적극적으로 대응 할 수 있도록 도와준다 중요하다 이거 
	}catch (ArrayIndexOutOfBoundsException  e) {
		e.printStackTrace();
	}catch(ArithmeticException e) {
		e.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}
	}

}
