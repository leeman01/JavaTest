package main.java.codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 잘몰라서 정답 
public class Day1107_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrays = {1,2,3,4,5,6};

		

	}
	// 그냥 홀수로 만드는 작업이랑 2의 개수를 구하는 작업을 분리하
	// 여기서는 홀수로 만드는 작업을 할려햇는데 정답은 이런식으로 풀었
	  // 최대공약수
    long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    public long nlcm(int[] num) {
        long answer = 1;
        for (int i = 0; i < num.length; i++) {
            long g = gcd(num[i], answer);
            answer = num[i] * answer / g;
        }
        return answer;
    }

}
