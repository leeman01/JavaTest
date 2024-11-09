package mathapi;

public class MathTest {

	public static void main(String[] args) {
		double data = 42.1954321;
		System.out.println("원본: " + data);
		System.out.println("ceil() : " + Math.ceil(data));  // 올림
		System.out.println("round() : " + Math.round(data)); // 반올림 5이상의수
		System.out.println("floor() : " + Math.floor(data)); // 버림
		System.out.println("Max() : " + Math.max(15,20)); // 둘중에 큰값
		System.out.println("Min() : " + Math.min(15,20)); // 둘중에 작은값
		System.out.println("pow() : " + Math.pow(4, 5)); // 거듭제곱
		System.out.println("sqrt() : " + Math.sqrt(9)); // 제곱근구하기
		
		System.out.println("PI : " + Math.PI);
		System.out.println("E : "  + Math.E);
	
	}
}
