package main.java.codingTest;
// 이진수로변환해서 1의개수를 파악하는 문제이다
// static을 항상 생각해서 쓰자 무작정 쓰면오히려 힘들어진
public class Day1106_2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println(solution1(78));
		System.out.println(solution2(15));

	}
	public static int solution2(int n) {
		int a = solution1(n); // 여기서 입력받은 값의 1의개수파악
		
		while(true) {
			++n;
			int b = solution1(n);
			if(a==b)
				break;
		}
			
		return n ;
	}
	
	
	// 여기서 이진수를 만들어 숫자파
	public static int solution1(int n) {
		int count=0;
	   StringBuilder a =new StringBuilder();
       while (true) {
    	   if(n%2==0) {
    		   a.append(0);
    	   }else {
    		   a.append(1);
    		   ++count;
    	   }
    	   n/=2;
    	   if(n==0) {
    		   break;
    	   }
    	   
       }
       return count;
    }

}
