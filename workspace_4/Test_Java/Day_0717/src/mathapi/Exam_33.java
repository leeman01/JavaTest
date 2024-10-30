/*
 * ArrayList에 저장된 데이터를 이용하여 합계와 평균을 구한후 저장하는 프로그램을 작성
 */
package mathapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam_33 {

	public static void main(String[] args) {
		List<String> source = Arrays.asList("홍길동 100 95 85","임꺽정 85 77 68","전우치 88 65 74",
				"손오공 100 99 87","사오정 74 58 99");
		StringBuffer buff1 = new StringBuffer();
		
		List <String> target =new ArrayList<>(); // 타겟안에는 "홍길동 100 95 85 xxx xx.xx"
		
		for(int i=0;i<source.size();++i) {
			String [] temp = source.get(i).split(" ");
			int sum=0;
			double avg=0;
			String a = source.get(i);
			String[] b = a.split(" ");
			String name = b[0];
			for(int j=1;j<b.length;++j) {
				int x = Integer.parseInt(b[j]);
				sum+=x;
			}
			avg = (double) sum /3;
			target.add(String.format("%s %3s %3s %3s %4d %.2f",name,b[1],b[2],b[3],sum,avg));
			buff1.append(a).append(" ").append(sum).append(" ").append(avg).append("\n");
			String x =buff1.toString();
			
			
		}
		int count=0;
		System.out.println(buff1);
		target.forEach((s)->System.out.println(s));
	}

}
