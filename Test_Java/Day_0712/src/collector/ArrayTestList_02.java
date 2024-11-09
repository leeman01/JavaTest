package collector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTestList_02 {

	public static void main(String[] args) {
		List <String> slist = Arrays.asList("아이스 아메리카노"
				,"더치 커피"
				,"가푸치노"
				,"카페라뗴"
				,"녹차라떼");
		for(String temp: slist)
			System.out.println(temp);
		
		slist.forEach((data->System.out.println(data)));
		
		
		ArrayList <String> slist1 = new ArrayList<>();
			slist1.add("2");
		String [] lipstick1 =  {"립밤","립글로스","틴트"};
		String [] lipstick2 = {"빨강","분홍","오렌지"};
		String a = lipstick1[0];
		System.out.println(a);
		for (String t:lipstick1)
			System.out.println(t);
		
	}

}
