/*
 * 새로 생긴 놀이기구는 인기가 매우 많아 줄이 끊이질 않습니다. 이 놀이기구의 원래 
 * 이용료는 price원 인데, 놀이기구를 N 번 째 이용한다면 원래 이용료의 N배를 받기로 하였습니다. 즉, 처음 이용료가 100이었다면 
 * 2번째에는 200, 3번째에는 300으로 요금이 인상됩니다.
놀이기구를 count번 타게 되면 현재 자신이 가지고 있는 금액에서 얼마가 모자라는지를 return 하도록 solution 함수를 완성하세요.
단, 금액이 부족하지 않으면 0을 return 하세요.
 */

package month7;

public class Num_24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(3,20,4));

	}
	// 와... 미쳐버리게따... 제약조건에  처음 가지고 있던 금액 money : 1 ≤ money ≤ 1,000,000,000,
	// 이라고 나와 있는데 int로 지정하면 타입이 맞지않다 
	private static long solution(int price,long money,int count) {
		for(int i=1;i<=count;++i) {
			money-=price*i ;
		}
		if (money>0)
			return 0 ;
		return Math.abs(money);
	}
	private static long answer(int price,long money,int count) {
		return Math.max(price * (count * (count + 1) / 2) - money, 0);
	}

}
