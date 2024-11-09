/*
 * [나머지사 1이되는 수 찾기]
 * 자연수 n이 매개변수로 주어집니다. n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 
 * x를 return 하도록 solution 함수를 완성해주세요. 답이 항상 존재함은 증명될 수 있습니다.
 */


package month7;

public class Num_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(12));

	}
	private static int solution(int n) {
		int cnt =1;
		while (true) {
			if(n%cnt==1)
				break;
			cnt+=1;
		}
		return cnt;
		
	}

}
