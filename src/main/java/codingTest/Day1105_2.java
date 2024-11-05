package main.java.codingTest;

import java.util.Arrays;

public class Day1105_2 {
// 다른 사람의 풀이
	public static int count;
    public static int zeroCount;
    public int[] solution(String s) {
 int[] answer = new int[2];
        count =0;
        zeroCount=0;
        recursive(s);
        answer[0] = count;
        answer[1] = zeroCount;
        return answer;
    }
    public static void recursive(String s){
        if(s.equals("1"))
            return;
        count++;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c=='0'){
                zeroCount++;
                continue;
            }
            sb.append(c);
        }
        recursive(Integer.toBinaryString(sb.length()));
    }

}
