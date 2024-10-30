package array_test;

import java.util.HashMap;
import java.util.HashSet;

public class LengthTest_128P {
	private static boolean isValidMove(int nx,int ny) {
		//  좌표평면상에서 (-5,-5) ~ (5,5) 사이의 범위에 있어야 한다 => 이 문제의 핵심은 길이를 구하는 것이므로
		// 음수부분을 양수로 변환해도 상관이 없다
		return 0<= nx && ny <11 && 0 <= ny && ny < 11;
		// x y 좌표가 범위를 벗어나지 않게하기위해 이렇게 만듦

	}
	private static final HashMap <Character,int[]> location = new HashMap<>();
	
	private static void initLocation() {
		location.put('U',new int[] {0,1});
		location.put('D',new int[] {0,-1});
		location.put('R',new int[] {1,0});
		location.put('L', new int [] {-1,0});
	}
	public int solution(String dirs) {
		initLocation();
		int x=5;
		int y=5;
		int cnt = 0;
		HashSet<String> answer = new HashSet<>();
		
		for(int i=0 ; i<dirs.length();i++) {
			int [] offset = location.get(dirs.charAt(i)) ;
			int nx = x + offset[0];
			int ny = y+ offset[1];
			if (! isValidMove(nx,ny)) 
				continue;
			answer.add(x +" "+y+" "+nx +" " + ny);
			answer.add(nx +" "+ny+" "+x +" " + y);
		}
		
		return answer.size()/2 ;
		
		
		
		
		
		
		
		
	}

}
