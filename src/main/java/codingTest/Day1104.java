package main.java.codingTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day1104 {
	  public String solution(String s) {
		    String [] list = s.split(" ");
				int[] list2 = new int[list.length];
				for(int i=0;i<list.length;++i) {
					list2[i] = Integer.parseInt(list[i]);
				}
				List<Integer> a = new ArrayList<>();
				for(int b: list2) {
					a.add(b);
				}
				a.sort(Comparator.reverseOrder());
				
				return String.valueOf(a.get(a.size()-1))+" " +String.valueOf(a.get(0));
				

		    }

}

