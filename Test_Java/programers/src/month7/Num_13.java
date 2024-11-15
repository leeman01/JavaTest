/*
 * 문제 설명[콜라즈추측]
1937년 Collatz란 사람에 의해 제기된 이 추측은, 주어진 수가 1이 될 때까지 다음 작업을 반복하면, 
모든 수를 1로 만들 수 있다는 추측입니다. 작업은 다음과 같습니다.

1-1. 입력된 수가 짝수라면 2로 나눕니다. 
1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다. 
2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다. 
예를 들어, 주어진 수가 6이라면 6 → 3 → 10 → 5 → 16 → 8 → 4 → 2 → 1 이 되어 총 8번 만에 1이 됩니다.
 위 작업을 몇 번이나 반복해야 하는지 반환하는 함수, solution을 완성해 주세요. 
단, 주어진 수가 1인 경우에는 0을, 작업을 500번 반복할 때까지 1이 되지 않는다면 –1을 반환해 주세요.
 */
package month7;

public class Num_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(answer(626331));

	}
	// 이거 기본타입을 long으로 안해서 문제가 생긴거다 int 로해서 마지막 테스트 때 
	// 계속 오류뜨던거임
	private static int solution(int num) {

		if(num==1)
			return 0;
		for(int i=1; i<500;++i) {
			if (num%2==0) {
				num/=2;
			}else if(num%2 !=0) {
				num = (num*3+1) ;
			}
			if (num==1)
				return i;
		}
		return -1 ;
			
	}
	 public static int answer(int num) {
		    long n = (long)num;
		    for(int i=0; i<500; i++){
		        if(n==1) return i; 
		      n = (n%2==0) ? n/2 : n*3+1;
		    }

		        return -1;
		    
		
	}
}
