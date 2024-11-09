import java.util.Scanner;

public class Bubblesort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
			Scanner keyin = new Scanner(System.in);
			int retail,retail1;
			//int [] data = {10,9,8,7,6,5,4,3,2,1};
			int cnt=0;
			int [] data = new int[10]; // 0 1 2 최대값 중간값 작은값 순서로
			for (int i=0;i<data.length;++i) {
				data[i] = (int) (Math.random()*100+1);
			}
			System.out.println("정렬전");
			for (int tmp: data)
				System.out.println(tmp);
			System.out.println("===============================");

			// 거품정렬 : 옆에있는 애들끼리만 비교해서 정렬
			System.out.println("정렬후");
			for (int i=0;i<data.length-1;++i) {
				cnt =0;
				for (int j=0; j<data.length-1-i ; j++) {
					
					if (data[j] < data[j+1]) { // 0과 1을 비교함 (data[i] < data[j]) 이면 내림차순 정렬이다
						retail = data[j];
						data[j]= data[j+1];
						data[j+1] = retail;	
						cnt++;
				}	
			}
				if (cnt==0) break; // 이렇게하면 더욱 성능이좋아진다
		}
			for (int tmp: data)
				System.out.println(tmp);
			System.out.println("===============================");
			System.out.println(cnt);
	}
}
	