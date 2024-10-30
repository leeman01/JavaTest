package study;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HashSet_studty {
	// 중복값이 안나오게 만드는 set
	public static void main(String[] args) {
		Set set = new HashSet();
		for(int i=0 ; set.size()<6;++i) {
			int num = (int)(Math.random()*45+1);
			set.add(num);			
		}
		System.out.println(set);
		// 하지만 set의 경우는 집어넣은 순서를 고려하지않기 떄문에 이를 고려하기 위해서는 LinkedList를 써야한다
	
		
	}

}
 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
 }