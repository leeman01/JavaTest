
// 7월 30일 풀이 
package array_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayTest_116p {
	public static void main(String[] args) {
		int [] answers = {1,2,3,4,5};
		int [] a = main(answers);
		for (int i : a)
			System.out.println(i);
	} // 이 방법대로 하면 어느 학생이 몇점을 맞아는지 파악하기가 어렵다 , 또한 패턴을 이중리스트로
	// 변경하면 더 좋을 거 같다
	public static int[] main(int[] answers) {
	
		int [] pat = {1,2,3,4,5} ;
		int [] pat1 = {2,1,2,3,2,4,2,5};
		int [] pat2 = {3,3,1,1,2,2,4,4,5,5};
		int cnt = 0,cnt1=0,cnt2=0;
		for(int i=0 ; i<answers.length;++i) {
			
			if(answers[i] == pat[i%pat.length]) {
				cnt+=1;
			}else if(answers[i]== pat1[i%pat1.length]) {
				cnt1+=1;
			}else if(answers[i]== pat2[i%pat2.length]) {
				cnt2+=1;
			}
		}
		List<Integer> list = Arrays.asList(cnt,cnt1,cnt2);
		return list.stream().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
	}
	private static int[] solution(int[] array) {
		
		int [][] pat = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
		int [] score = new int[3];
		for(int i =0 ; i<array.length;++i) {
			for(int j=0;j<pat.length;++j) {
				if (array[i]==pat[j][i % pat[j].length]) {
					score[i]+=1;
				}
			}
			
		}
		// 여기에서 가장 큰 값을 찾아 반환한다
		int maxscore = Arrays.stream(score).max().getAsInt();
		// 값을 반환한 후에는 몇번학생이 최고점수를 맞앗는지 리스트를 활용해서 구함
		ArrayList<Integer> anser = new ArrayList();
		for(int i=0;i<score.length;++i) {
			if (score[i]==maxscore) {
				anser.add(i+1);
			}
		}
		return anser.stream().mapToInt(Integer::intValue).toArray();

	}
}
