/*
 * [문제] int 배열 10개를 선언하고
 * 난수룰 1~100 사이 발생시켜 초기화한다
 *  0-9 1 8 2-7 3-6 4-5 끼리 교환
 */
public class Exam_25 {

	public static void main(String[] args) {
		int temp;
		int [] iary = new int [10];
		for (int i=0;i<iary.length;++i) {
			iary[i]= (int) (Math.random()*100+1);
			System.out.println(iary[i]);
			
		}
		System.out.println("===============");
		 for (int k=0; k <iary.length/2;++k){
			 temp = iary[k];
			 iary[k] = iary[iary.length-(k+1)];
			 iary[iary.length-(k+1)] =temp;
		 }
			 
		 }
		
		
		 
}
