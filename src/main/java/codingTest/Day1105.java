package main.java.codingTest;

import java.util.Arrays;

public class Day1105 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub'
		String s = "        leeman ";
		String [] ans = s.split(" ");
		System.out.println(Arrays.toString(ans));
		System.out.println("'"+solution(s)+"'");

	}
	public static String solution(String s) {
		String[] arr = s.split(" ");
		StringBuilder build = new StringBuilder();
		for(String a: arr) {
			if(a.length()==0) {
				build.append("-");
			}
			else {
				build.append(a.substring(0,1).toUpperCase()).append(a.substring(1).toLowerCase())
				.append(" ");	
			}

		}
		return build.toString().strip().replace("-", " ");
	}

}
