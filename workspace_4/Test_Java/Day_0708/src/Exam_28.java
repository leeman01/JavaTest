/* 
 * [문제] 정수 배열 6 * 6  생성(1,10 사이의 난수 발생  6행과 6열을 비어있게 0으로 설정해라
 *  
 */
public class Exam_28 {

	public static void main(String[] args) {
		int [][] iary= new int[6][6];
		int sum1,sum2=0;
		for (int i =0;  i<iary.length-1 ; ++i) {
			sum1=0;
			
			for (int j=0 ; j<iary[i].length-1;++j) {
				iary[i][j]= (int)(Math.random()*10+1);
				
				
				iary[i][5] += iary[i][j];
				iary[5][j] += iary[i][j];
		
		
			}
		}
		for (int i =0;  i<iary.length ; ++i) {
			for (int j=0 ; j<iary[i].length;++j) {
				System.out.printf("%2d",iary[i][j]);
				
			}
			System.out.println();
			
		}
	}

}
