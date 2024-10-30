package ecpttest;

public class ExceptionTest_02 {

	public static void main(String[] args) throws Exception {
		double result = divide(10,0);
		System.out.println(result);

	}
	
	public static double divide(int a, int b) throws Exception {
		// 1) 익셉션을 직접 처리
		try {
			if (b==0 )
				throw new Exception("분모는 0이면 안됩니다.");
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		// 2) 익셉션을 전가
		if (b==0) 
			throw new Exception("분모는 0이면 안됩니다.");
		
		return a/(double)b;
		
	}
	
	
}
