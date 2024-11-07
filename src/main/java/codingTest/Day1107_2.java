package main.java.codingTest;
// 틀린거
// 뭔지 모르겟네 이건 효율성 오류로 틀림 판정 받음
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Day1107_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a ="real";
		int[] b = {1,3,2,5,4,5,2,3};
		int c = solution(6,b);
		System.out.println(c);
	}
	public static int solution(int k, int[] target) {
		int cnt=1;
		int sum=0;
		// 여기서 각 종에 따른귤의 개수가 몇개인지 알리는 리스트가 필요할거같다
		int[] ans = new int[target.length];
		for(int a:target) {
			ans[a]+=1;
		}
		Arrays.sort(ans);
		Integer[] ansInteger = Arrays.stream(ans).boxed().toArray(Integer[]::new);
        Arrays.sort(ansInteger, Collections.reverseOrder());  // 내림차순 정렬
        for(Integer aa : ansInteger) {
        	sum+=aa;
        	if(sum>=k)
        		break;
        	++cnt;
        }
		return cnt;
	}

}
