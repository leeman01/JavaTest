package study;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class TreeSet_study {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set set = new TreeSet();
		
		for(int i=0;set.size()<6;++i) {
			int num = (int)(Math.random()*45+1);
			set.add(new Integer(num));
			
		}
		System.out.println(set);
		
		TreeSet set1 = new TreeSet();
		String form = "b";
		String to ="d";
		set1.add("abc"); set1.add("alien"); set1.add("bat");
		set1.add("car"); set1.add("Car"); set1.add("disc");
		set1.add("dance"); set1.add("dZZZ"); set1.add("dzzzzzz");
		set1.add("elephant"); set1.add("elevator"); set1.add("fan");
		set1.add("flower");
		System.out.println(set1);
		System.out.println(set1.subSet(form, to));
		
		TreeSet set3 = new TreeSet();
		int [] score= {1,2,3,4,5,6,67,8,8};
		for (int i=0;i<score.length;++i) {
			set3.add(score[i]);
		}
		System.out.println(set3.headSet(50)); // 50보다 작은값
		System.out.println(set3.tailSet(50)); // 50보다 큰값
		set3.forEach( i-> System.out.println(i));
		
	
	}

}