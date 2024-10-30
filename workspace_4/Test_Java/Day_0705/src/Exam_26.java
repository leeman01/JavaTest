/*
 * [문제] 정수배열 10개를 선언하고 난수 1~50까지 발생시켜 초기화한다 배열안에 들어간 값은 중복될수없다
 * 중복제거 => 
 */
public class Exam_26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] iary = new int [10];
		
		for (int i=0;i<iary.length;++i) {
			
			iary[i]= (int)(Math.random()*50+1); // 중복되지 않으려면 (Math.random()*50+1) 부분의 숫자가 방의크기와 같거나 커야한다, 작으면 무한반복이다
			for (int j=0;j<i;j++) {
				
				if ((iary[i]==iary[j]))
					//iary[i]= (int)(Math.random()*50+1);
					i=i-1;
					continue;
						
			}
		}
		for (int z=0 ; z< iary.length ; ++z) System.out.println(iary[z]);
	}

}
