package ecpttest;

import myexception.OddException;

public class Exam_32 {

	public static void main(String[] args) throws Exception {
		int [] myAry = new int[10];
//		System.out.println(even());
//		 try로 예외처리
		int count=0;
		while (true) {
			try {
				myAry[count] = even();
			}catch (OddException e) {
				continue;
			}
			count++;
			if (count==10) break; 
		}
		
		for(int a: myAry) {
			System.out.print(a + " ");
		}
		// 주요코드 
		// advanced for문으로 출력
	}
	// 장수 값 난수를 발생시켜 
	// 홀수를 발생시키면 예외로 처리
	// 짝수이면 반환
	public static int even() throws OddException{
		int a = (int) (Math.random()*100+1);
		int b = a%2;
		if (b!= 0) throw new OddException(null);
		return a;
		
	}
}
