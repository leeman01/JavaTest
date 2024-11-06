package main.java.codingTest;
//
/*
 * 푸는데 시간이 오래걸린 이유 :  ++ / = 의 계산순서를 헷갈려서 무엇이 문제인지
 * 파악하지 못햇다
 * 이로인해 자바에서 연산식의 우선순위를 더 잘 알아야함을 알았
 */
public class Day1106_1 {
	static int count= 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(15));

	}
	public static int solution(int n) {
        int answer = 0;
        int sum=0;
        int num=1;
        while(true) {
        	sum+=num;
        	System.out.println("숫자의 합: " + sum);
        	num+=1;
        	if(sum==n) { 
        		answer++;
        		num = ++count;
        		sum=0;
        		System.out.println("정답이 발생했을때의 숫자: " +  num);
        	}else if(sum>n) {
        		num = ++count;
        		System.out.println("틀림이 발생햇을 때의 숫자: " + num);
        		sum=0;
        	}
        	
        	if(num>n) {
        		break;
        	}
        }
		return answer;
    }

}
