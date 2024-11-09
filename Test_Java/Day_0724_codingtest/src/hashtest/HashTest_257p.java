package hashtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class HashTest_257p {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static int[] solution(String[] genres,int[] plays) {
		// 1. 각 장르별 무엇이 가장많이 재생되엇는지 파악
		// 2. 그 장르 중 가장 많이 재생된 것을 인덱스로 정렬하여표현해서 2개만 선정
		HashMap<String,ArrayList<int[]>> genremap = new HashMap<>();
		HashMap<String,Integer> playmap= new HashMap<>();
		for(int i=0;i<genres.length;++i) {
			if(!genremap.containsKey(genres[i])) {
				genremap.put(genres[i], new ArrayList<>());
				playmap.put(genres[i],0);
			}
			genremap.get(genres[i]).add(i,new int[] {i,plays[i]});
			playmap.put(genres[i],playmap.get(genres[i])+plays[i]);
			}
		Stream <Map.Entry<String, Integer>> sortedgenre = playmap.entrySet().stream().sorted((o1,o2)->Integer.compare(o2.getValue(),o1.getValue()));
		sortedgenre.forEach(entry-> {
			
	
		
		
	}


