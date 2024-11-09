/*
 * 정수값을 입력받아 그 정수가 소수인지 판단하는 메소드를 작성하시오
 * public static isPrime(int)
 */
import java.util.Scanner;

public class MethodTest_02 {

    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
//        System.out.println("정수를 입력하세요");
//        int number = keyin.nextInt();
//        boolean output = isPrime(number);
//
//        System.out.println(number + "는 " + ((output) ? "소수입니다" : "소수가 아닙니다"));
//        keyin.close();  // Scanner 객체를 닫아줍니다.
        
        System.out.println("숫자를 입력: ");
        int a=keyin.nextInt();
        boolean out = isEven(a);
        System.out.println(a + "는 " + ((out) ? "짝수입니다" : "짝수가 아닙니다"));
    }

    public static boolean isPrime(int a) {
        if (a <= 1) {
            return false;  // 1과 그 이하의 숫자는 소수가 아닙니다.
        }
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean isEven(int n) {
    	boolean result = false;
    	if (n%2==0)
    		return true;
    	return false;
    }
}

