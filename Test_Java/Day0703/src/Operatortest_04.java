
public class Operatortest_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = null;
		int x=3;
		
		result = (x%2==0) ? "짝수":"홀수";
		System.out.println(result);
		
		x = 0;
		result= (x>0) ? "양수" : "음수";
		System.out.println(result);
		
		x=12;
		result= (x>0) ? "양수" :
				(x<0) ? "음수": "0입니다" ;
		
		System.out.println(result);
		
		
		int a,b,c;
		a = 11;
		b=20;
		
		System.out.println("a="+a+",b="+b);
		
		c=a;
		a=b;
		b=c;
		System.out.println("a="+a+",b="+b);
	}

}
