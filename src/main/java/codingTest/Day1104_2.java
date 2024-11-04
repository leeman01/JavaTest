package main.java.codingTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day1104_2 {
	public int solution(int []A, int []B)
    {
     int c=0;
		List<Integer>a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		for(int x=0;x<A.length;++x) {
			a.add(A[x]);
			b.add(B[x]);
		}
		a.sort(null);
		b.sort(Comparator.reverseOrder());
		for(int i=0;i<a.size();++i) {
			
			c+=a.get(i)*b.get(i);
		}
		return c;
    }
}
