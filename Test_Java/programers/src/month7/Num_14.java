/*
 * 문제 설명[음양더하기]
어떤 정수들이 있습니다. 이 정수들의 절댓값을 차례대로 담은 정수 배열 absolutes와 
이 정수들의 부호를 차례대로 담은 불리언 배열 signs가 매개변수로 주어집니다. 
실제 정수들의 합을 구하여 return 하도록 solution 함수를 완성해주세요.

제한사항
absolutes의 길이는 1 이상 1,000 이하입니다.
absolutes의 모든 수는 각각 1 이상 1,000 이하입니다.
signs의 길이는 absolutes의 길이와 같습니다.
signs[i] 가 참이면 absolutes[i] 의 실제 정수가 양수임을, 
렇지 않으면 음수임을 의미합니다.

 * 
 */

package month7;

import java.util.ArrayList;
import java.util.Arrays;

public class Num_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3};
		boolean[] b = {false,false,true};
		System.out.println(answer(a,b));

	}
	private static int solution(int[] absolutes , boolean[] signs) {
		ArrayList<Integer> array = new ArrayList<>();
		for(int i=0;i<signs.length;++i) {
			if (signs[i]==true){
				array.add(absolutes[i]*1);
			}else {
				array.add(absolutes[i]*-1);
			}
		}
		return array.stream().mapToInt(Integer::intValue).sum();
		
		
	} // 외우려고하지말고 이해를 하자 => 삼항 연산자 사용 플러스 무조건 자료구조 변형해서
	// 하려고들지말자 
	private static int answer(int[] absolute,boolean[] sign) {
		int answer=0;
		for(int i=0;i<sign.length;++i) {
			answer+= (sign[i] ? absolute[i]*1 : absolute[i]*-1);
			 
		}
		return answer ;
	}

}
