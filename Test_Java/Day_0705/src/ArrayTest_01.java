
public class ArrayTest_01 {

	public static void main(String[] args) {
		// 정수 배열 생성하기
//		
//		int [] iary=new int[10] ; // 방이 10개인 상태 인덱스 0~9까지 있음
//		System.out.println(iary[0]);
		
		// System.out.println(iary[10]); indexoutofline
		
//		iary[0] = 15 ;
//		iary[1] = 5 ;
//		iary[2] = 1 ;
		
//		int [] iary = {15,5,7,0,0,0,0,0} ; // 이때의 경우 방 크기가 3개가된다
		//System.out.println(iary[0]);
//		int [] iary = new int[]{15,5,7,0,0,0,0,0}; 이렇게 사용하지 마라
		int [] iary = new int [10];
		// Math.random() : 0  이상 1 미만의 수
		
		// 데이터를 발생시켜 초기화(100: 0~99 ,101:0~100)
		for (int i =0 ; i< iary.length;++i)
			iary[i] =  (int)(Math.random() * 100) ; // * 100에서 100은 경우의 수를 의미하므로 총 경우는 0~99까지 100개가 나온다
			// iary[i] =  (int)(Math.random() * 100) ; (10~109) 까지 100개의 경우의 수
		//System.out.println(iary[0]);
		System.out.println(iary.length); 
		// iary.length =15 ; 배열 크기 수정은 불가능하다
		for (int i=0;i<iary.length;++i) System.out.println(iary[i]);
		
	}

}
