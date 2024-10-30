package hashtest;

import java.util.HashMap;

public class HashTest_243p {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1 원하는 제품과 개수를 해시맵으로 만들어야 함
		

	}
	private static int solution(String[] string,int[] number,String[] discount) {
		int cnt=0;
		//1 원하는 제품과 개수를 해시맵으로 만들어야 함
		HashMap<String,Integer> hashmap = new HashMap<>();
		for (int i=0;i<string.length;++i) {
			hashmap.put(string[i], number[i]);
		}
		// 할인 하는 품목을 다시 해시맵으로 만들자
		for(int i=0 ; i<discount.length-9;i++) {
			HashMap<String,Integer> discount10d =new HashMap<>();
			
			for(int j=i;j<i+10;++j) {
				if(hashmap.containsKey(discount[j])) {
					discount10d.put(discount[j], discount10d.getOrDefault(discount[j], 0)+1);
				}
			}
			if (discount10d.equals(hashmap))
				cnt++;
		}
		 // 이렇게하면 각 할인 품목에 1이 디폴트값이고 추가로 생기면 +1을 할수잇음
		
		
		
		
		return cnt;
		
	}
}
