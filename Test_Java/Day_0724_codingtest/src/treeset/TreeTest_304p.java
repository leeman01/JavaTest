package treeset;

public class TreeTest_304p {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static int solution(int n , int a, int b) {
		int answer;
		for(answer=0;a!=b;answer++) {
			a= (a+1)/2;
			b=(b+1)/2;
		}
		return answer;
	}
}
//+1을 더하는 이유
//토너먼트에서 두 참가자의 번호가 a, b일 때, 이들이 다음 라운드에 진출하면 그들의 새로운 번호는 (a+1)/2와 (b+1)/2가 됩니다.
//
//왜 1을 더할까?
//1을 더한 후 나누기를 하는 이유는 홀수와 짝수 번호 참가자가 다음 라운드에서 같은 대결 조에 들어가기 때문입니다. 예를 들어, 참가자가 1번과 2번인 경우, 이들은 1라운드에서 만납니다. 그런데 2라는 번호는 1로 바뀌고, 1이라는 번호는 여전히 1입니다. 만약 번호 a와 b가 같은 조에서 대결해야 한다면, 이들을 같은 범위로 묶어야 합니다.
//
//예를 들어, a=1일 때 (1 + 1) / 2 = 1
//a=2일 때도 (2 + 1) / 2 = 1