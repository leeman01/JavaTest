import java.util.Scanner;

public class Exam_28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
			Scanner keyin = new Scanner(System.in);
			int retail,retail1;
			
			int [] data = new int[10]; // 0 1 2 최대값 중간값 작은값 순서로
			for (int i=0;i<data.length;++i) {
				data[i] = (int) (Math.random()*100+1);
			}
			System.out.println("정렬전");
			for (int tmp: data)
				System.out.println(tmp);
			System.out.println("===============================");
//			if (data[0] < data[1]) {
//				retail = data[0];
//				data[0] = data[1];
//				data[1] = retail;
//			}// data[0]변수에는 data[1]보다 큰값
//	
//			if (data[0] < data[2]) {
//				retail = data[0] ;
//				data[0] = data[2] ;
//				data[2] = retail;
////				
//			}// data[0]변수에는 가장 큰값
////			
//			if (data[1] < data[2]) {
//				retail = data[1] ;
//				data[1] = data[2] ;
//				data[2] = retail;
//			} // meduian 에는 data[2]보다 큰값
			System.out.println("정렬후");
			for (int i=0;i<data.length;++i) {
				for (int j=i+1;j<data.length;++j) {
					if (data[i] > data[j]) { // 0과 1을 비교함 (data[i] < data[j]) 이면 내림차순 정렬이다
						retail = data[i];
						data[i] = data[j];
						data[j] = retail;
					}
				}
			}
				
			for (int tmp: data)
				System.out.println(tmp);
			
		}
	}

	