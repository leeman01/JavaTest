/*
 * [문제] 정수 2개를 입력받는다.
 * 변수의 이름 max,min이라는 변수를 준비한 후 입력받은 변수 중 작은 값이 min 에들어가잇어야 한다 반대의 경우 무조건 바꿔야한다
 * 입력받은 두값은 같은값으로 들어오지 않는다 다른값이 입력되도록 한다
 */

import java.util.Scanner;

public class Exam_12 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int min ,max,median,retail,retail1;
//		System.out.print("정수를 입력하시오: ");
//		min = keyin.nextInt();
//		
//		System.out.print("정수를 입력하시오: ");
//		max = keyin.nextInt();
//		
//		if (min == max) {
//			System.out.println("같은값입력은 거부한다");
//			return ;
//		}else if (min < max) {
//			System.out.println("작은값은"+","+ min+","+"큰값은"+max);
//		}else if(min >max) {
//			retail = min ; //여기서 작은값을 할당해준다
//			min= max;
//			max = retail ;
//			System.out.println("작은값은"+ min+","+"큰값은"+max);
//		}
		System.out.print("최소 정수를 입력하시오1: ");
		min = keyin.nextInt();
		
		System.out.print("최대 정수를 입력하시오2: ");
		max = keyin.nextInt();
		
		System.out.print("중간 정수를 입력하시오3: ");
		median = keyin.nextInt();
		
//		if (max < median && median < min ) {
//			retail = max; // 가장 작은값
//			max = min ; 
//			min = retail ;
//			System.out.printf("큰값은 %d, 작은값은 %d, 중간값은 %d",max,min,median);
//		} else if (median > max && median > min && min> max) {
//			retail = max; // 최소값
//			retail1 = min; //중간값
//			max= median;
//			min = retail;
//			median = retail1;	
//			System.out.printf("큰값은 %d, 작은값은 %d, 중간값은 %d",max,min,median);		
//		} else if  (median > max && median > min && min< max) {
//			retail = min; // 최대값
//			retail1 = max;
//			max= median;
//			min = retail;
//			median = retail1;	
//			System.out.printf("큰값은 %d, 작은값은 %d, 중간값은 %d",max,min,median);
//			
//		}else {
//			System.out.printf("큰값은 %d, 작은값은 %d, 중간값은 %d",max,min,median);
//		}
		
		if (max < median) {
			retail = max;
			max = median;
			median = retail;
		}// max변수에는 median보다 큰값
//
		if (max < min) {
			retail = max ;
			max = min ;
			min = retail;
//			
		}// max변수에는 가장 큰값
//		
		if (median < min) {
			retail = median ;
			median = min ;
			min = retail;
		} // meduian 에는 min보다 큰값
		System.out.printf("큰값은 %d, 작은값은 %d, 중간값은 %d",max,min,median);
		
	}
}
				