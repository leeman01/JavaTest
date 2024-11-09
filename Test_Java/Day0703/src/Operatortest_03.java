
public class Operatortest_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x =0,y;
		++x;
		System.out.println(x);
		System.out.println(++x);
		
		x=0;
		x++;
		System.out.println(x);
		System.out.println(x++); // 출력한 다음에 최종적으로 x=2가 되어있음
		
		x=0;
		y=++x;
		System.out.println(x+","+y);
		
		x=0;
		y=x++;
		System.out.println(x+","+y);
		
		x=0;
		y = ++x + x++;
		System.out.println(x+","+y);
		
		
 
	}

}
